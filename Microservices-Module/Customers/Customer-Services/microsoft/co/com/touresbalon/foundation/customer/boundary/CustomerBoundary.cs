using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Text;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.boundary
{
    public class CustomerBoundary
    {
        private string ds = "Data Source=DESKTOP-FV7QILS\\SQLEXPRESS;Initial Catalog=customers;Integrated Security=True";


        public Customer getCustomer(string id)
        {
            Customer customer = new Customer();

            using (SqlConnection connection = new SqlConnection(ds))
            {
                StringBuilder sql = new StringBuilder();
                sql.Append("SELECT Id, first_name, last_name, phone_number, email, password, ");
                sql.Append("creditcard_number, creditcard_type, status FROM [customers].dbo.customer WHERE Id=@id");

                SqlCommand command = new SqlCommand(sql.ToString(), connection);
                command.Parameters.Add("@id", SqlDbType.NVarChar).Value = id;

                connection.Open();

                try
                {
                    SqlDataReader reader = command.ExecuteReader();
                   if (reader.Read())
                    {
                        customer = new Customer() { Id =  reader.GetString(0), first_name = reader.GetString(1),
                            last_name = reader.GetString(2), phone_number = reader.GetString(3), email = reader.GetString(4),
                            password = reader.GetString(5), creditcard_number = reader.GetString(6),
                            creditcard_type = reader.GetString(7), status = reader.GetString(8)};
                    }
                    else
                    {
                        connection.Close();
                        return customer;
                    }
                }
                catch (Exception ex)
                {
                    connection.Close();
                    return new Customer() { Id="7", creditcard_number=ex.StackTrace, email = ex.Message};
                }
            }
            customer.address = getCustomerAddress(id);
            return customer;
        }

        public IList<Address> getCustomerAddress(string customer_id)
        {
            using (SqlConnection connection = new SqlConnection(ds))
            {
                StringBuilder sql = new StringBuilder();
                sql.Append("SELECT ad.Id, ad.street, ad.state, ad.zip, ad.country, ad.address_type, ad.city ");
                sql.Append("FROM [customers].dbo.address ad INNER JOIN [customers].dbo.customer_address cus ");
                sql.Append("ON ad.Id = cus.address_id WHERE cus.customer_id = @id");

                SqlCommand command = new SqlCommand(sql.ToString(), connection);
                command.Parameters.Add("@id", SqlDbType.NVarChar).Value = customer_id;

                connection.Open();

                try
                {
                    List<Address> addresses = new List<Address>();

                    SqlDataReader reader = command.ExecuteReader();
                    while (reader.Read())
                    {
                        Address address = new Address()
                        {
                            Id = Int32.Parse(reader.GetValue(0).ToString()),
                            street = reader.GetString(1),
                            state = reader.GetString(2),
                            zip = reader.GetString(3),
                            country = reader.GetString(4),
                            address_type = reader.GetString(5),
                            city = reader.GetString(6)
                        };
                        addresses.Add(address);
                    }

                    connection.Close();
                    return addresses;
                }
                catch (Exception ex)
                {
                    connection.Close();
                    return new List<Address>();
                }
            }
        }

        public IList<Customer> getCustomers(int pagina, int regPagina)
        {
            IList<Customer> customers = new List<Customer>();

            using (SqlConnection connection = new SqlConnection(ds))
            {
                StringBuilder sql = new StringBuilder();
                sql.Append("SELECT Id, first_name, last_name, phone_number, email, password, ");
                sql.Append("creditcard_number, creditcard_type, status FROM ");
                sql.Append("(SELECT ROW_NUMBER()Over(Order by dbo.customer.first_name ASC) As RowNum, ");
                sql.Append("Id, first_name, last_name, phone_number, email, password,");
                sql.Append("creditcard_number, creditcard_type, status FROM [customers].dbo.customer) AS Resultado ");
                sql.Append("WHERE RowNum BETWEEN (@pagina -1) * @regPagina + 1 AND @pagina * @regPagina");

                SqlCommand command = new SqlCommand(sql.ToString(), connection);
                command.Parameters.Add("@pagina", SqlDbType.Int);
                command.Parameters["@pagina"].Value = pagina;
                command.Parameters.Add("@regPagina", SqlDbType.Int);
                command.Parameters["@regPagina"].Value = regPagina;

                connection.Open();

                try
                {
                    SqlDataReader reader = command.ExecuteReader();
                    while (reader.Read())
                    {
                        Customer customer = new Customer()
                        {
                            Id = reader.GetString(0),
                            first_name = reader.GetString(1),
                            last_name = reader.GetString(2),
                            phone_number = reader.GetString(3),
                            email = reader.GetString(4),
                            password = reader.GetString(5),
                            creditcard_number = reader.GetString(6),
                            creditcard_type = reader.GetString(7),
                            status = reader.GetString(8)
                        };

                        customers.Add(customer);
                    }
                    return customers;
                }
                catch(Exception ex)
                {
                    connection.Close();
                    customers.Add(new Customer() { Id = "7", creditcard_number = ex.StackTrace, email = ex.Message });
                    return customers;
                }
            }
        }

        public string createCustomer(Customer customer)
        {
            SqlTransaction transaction;
            using (SqlConnection connection = new SqlConnection(ds))
            {
                StringBuilder sql = new StringBuilder();
                sql.Append("INSERT INTO [customers].dbo.customer (Id, first_name, last_name, phone_number, ");
                sql.Append("password, email, creditcard_number, creditcard_type, status ) VALUES ( @Id, ");
                sql.Append("@first_name, @last_name, @phone_number, @password, @email, @creditcard_number, ");
                sql.Append("@creditcard_type, @status)");

                try
                {
                    connection.Open();
                    transaction = connection.BeginTransaction();

                    SqlCommand command = new SqlCommand(sql.ToString(), connection, transaction);
                    command.Parameters.Add("@Id", SqlDbType.NVarChar).Value = customer.Id;
                    command.Parameters.Add("@first_name", SqlDbType.NVarChar).Value = customer.first_name;
                    command.Parameters.Add("@last_name", SqlDbType.NVarChar).Value = customer.last_name;
                    command.Parameters.Add("@phone_number", SqlDbType.NVarChar).Value = customer.phone_number;
                    command.Parameters.Add("@password", SqlDbType.NVarChar).Value = customer.password;
                    command.Parameters.Add("@email", SqlDbType.NVarChar).Value = customer.email;
                    command.Parameters.Add("@creditcard_number", SqlDbType.NVarChar).Value = customer.creditcard_number;
                    command.Parameters.Add("@creditcard_type", SqlDbType.NVarChar).Value = customer.creditcard_type;
                    command.Parameters.Add("@status", SqlDbType.NVarChar).Value = customer.status;

                    command.ExecuteNonQuery();

                    createAddress(customer.Id, customer.address, connection, transaction);

                    transaction.Commit();
                    connection.Close();

                }
                catch(Exception ex)
                {
                    connection.Close();
                    return ex.Message;
                }
            }


            return "OK";
        }

        public string deleteCustomer(string id)
        {
            using(SqlConnection connection = new SqlConnection(ds))
            {
                SqlCommand command = new SqlCommand("DELETE FROM [customers].dbo.customer WHERE Id = @Id", connection);
                command.Parameters.Add("@Id", SqlDbType.NVarChar).Value = id;
                connection.Open();

                try
                {
                    command.ExecuteNonQuery();
                    connection.Close();
                }catch(Exception e)
                {
                    connection.Close();
                    return "ERROR";
                }
            }

            return "OK";
        }

        public string updateCustomer(Customer customer)
        {
            using (SqlConnection connection = new SqlConnection())
            {
                StringBuilder sql = new StringBuilder();
                sql.Append("UPDATE [customers].dbo.customer SET first_name = @first_name, last_name = @last_name, ");
                sql.Append("phone_number = @phone_number, password = @password, email = @email, ");
                sql.Append("creditcard_number = @creditcard_number, creditcard_type = @creditcard_type, status = @status ");
                sql.Append("WHERE Id = @Id");

                try
                {
                    connection.Open();

                    SqlCommand command = new SqlCommand(sql.ToString(), connection);
                    command.Parameters.Add("@Id", SqlDbType.NVarChar).Value = customer.Id;
                    command.Parameters.Add("@first_name", SqlDbType.NVarChar).Value = customer.first_name;
                    command.Parameters.Add("@last_name", SqlDbType.NVarChar).Value = customer.last_name;
                    command.Parameters.Add("@phone_number", SqlDbType.NVarChar).Value = customer.phone_number;
                    command.Parameters.Add("@password", SqlDbType.NVarChar).Value = customer.password;
                    command.Parameters.Add("@email", SqlDbType.NVarChar).Value = customer.email;
                    command.Parameters.Add("@creditcard_number", SqlDbType.NVarChar).Value = customer.creditcard_number;
                    command.Parameters.Add("@creditcard_type", SqlDbType.NVarChar).Value = customer.creditcard_type;
                    command.Parameters.Add("@status", SqlDbType.NVarChar).Value = customer.status;

                    command.ExecuteNonQuery();
                    connection.Close();

                    return "OK";
                }
                catch
                {
                    return "ERROR";
                }
            }
        }

        private void createAddress(string customer_id, IList<Address> addresses, SqlConnection connection, SqlTransaction transaction)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("INSERT INTO [customers].dbo.address (Id, street, state, zip, country, address_type, city) ");
            sql.Append("SELECT NEXT VALUE FOR [customers].dbo.seq_address, @street, @state, @zip, @country, @address_type, @city");

            StringBuilder sqlString = new StringBuilder();
            sqlString.Append("INSERT INTO [customers].dbo.customer_address (address_id, customer_id) ");
            sqlString.Append("SELECT CONVERT(bigint,current_value), @customer_id FROM sys.sequences WHERE name = 'seq_address'");


            SqlCommand command = new SqlCommand(sql.ToString(), connection, transaction);
            
            foreach (Address address in addresses)
            {
                command.Parameters.Add("@customer_id", SqlDbType.NVarChar).Value = customer_id;
                command.Parameters.Add("@street", SqlDbType.NVarChar).Value = address.street;
                command.Parameters.Add("@state", SqlDbType.NVarChar).Value = address.state;
                command.Parameters.Add("@zip", SqlDbType.NVarChar).Value = address.zip;
                command.Parameters.Add("@country", SqlDbType.NVarChar).Value = address.country;
                command.Parameters.Add("@address_type", SqlDbType.NVarChar).Value = address.address_type;
                command.Parameters.Add("@city", SqlDbType.NVarChar).Value = address.city;

                command.ExecuteNonQuery();

                command = new SqlCommand(sqlString.ToString(), connection, transaction);
                command.Parameters.Add("@customer_id", SqlDbType.NVarChar).Value = customer_id;

                command.ExecuteNonQuery();
            }
        }
    }
}