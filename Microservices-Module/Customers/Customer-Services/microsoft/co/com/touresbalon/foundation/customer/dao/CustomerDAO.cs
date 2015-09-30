using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using Customer_Services.microsoft.co.com.touresbalon.foundation.resource.exception;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Text;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.dao
{
    public class CustomerDAO
    {
        /**
            Consulta un cliente con sus direcciones asociadas
        */
        public Customer getCustomer(string id)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("SELECT Id, first_name, last_name, phone_number, email, ");
            sql.Append("creditcard_number, creditcard_type, status FROM [customers].dbo.customer WHERE Id=@id");

            Customer customer = new Customer();
            
            using (SqlConnection connection = new SqlConnection())
            {
               connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;

                using (SqlCommand command = new SqlCommand(sql.ToString(), connection))
                {
                    command.Parameters.Add("@id", SqlDbType.NVarChar).Value = id;
                    connection.Open();

                    try
                    {
                        SqlDataReader reader = command.ExecuteReader();
                        if (reader.Read())
                        {
                            customer = new Customer()
                            {
                                Id = reader.GetString(0),
                                first_name = reader.GetString(1),
                                last_name = reader.GetString(2),
                                phone_number = reader.GetString(3),
                                email = reader.GetString(4),
                                creditcard_number = reader.GetString(5),
                                creditcard_type = reader.GetString(6),
                                status = reader.GetString(7)
                            };
                            return customer;
                        }
                        else
                        {
                            throw new BusinessException("The customer not exist");
                        }
                    }
                    catch (PlatformException ex)
                    {
                        throw new PlatformException(ex.Message, ex);
                    }
                    catch (BusinessException ex)
                    {
                        throw ex;
                    }
                }
            }
        }

        /**
            Obtiene una lista de clientes
            @pagina numero de pagina a consultar

            @regPagina numero de registros por pagina
        */
        public IList<Customer> getCustomers(int pagina, int regPagina)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("SELECT Id, first_name, last_name, phone_number, email, ");
            sql.Append("creditcard_number, creditcard_type, status FROM ");
            sql.Append("(SELECT ROW_NUMBER()Over(Order by dbo.customer.first_name ASC) As RowNum, ");
            sql.Append("Id, first_name, last_name, phone_number, email, ");
            sql.Append("creditcard_number, creditcard_type, status FROM [customers].dbo.customer) AS Resultado ");
            sql.Append("WHERE RowNum BETWEEN (@pagina -1) * @regPagina + 1 AND @pagina * @regPagina");

            IList<Customer> customers = new List<Customer>();

            using (SqlConnection connection = new SqlConnection())
            {
                connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;

                using (SqlCommand command = new SqlCommand(sql.ToString(), connection))
                {

                    command.Parameters.Add("@pagina", SqlDbType.Int).Value = pagina;
                    command.Parameters.Add("@regPagina", SqlDbType.Int).Value = regPagina;

                    try
                    {
                        connection.Open();
                        SqlDataReader reader = command.ExecuteReader();

                        if (reader.HasRows)
                        {
                            while (reader.Read())
                            {
                                Customer customer = new Customer()
                                {
                                    Id = reader.GetString(0),
                                    first_name = reader.GetString(1),
                                    last_name = reader.GetString(2),
                                    phone_number = reader.GetString(3),
                                    email = reader.GetString(4),
                                    creditcard_number = reader.GetString(5),
                                    creditcard_type = reader.GetString(6),
                                    status = reader.GetString(7)
                                };
                                customers.Add(customer);
                            }
                            return customers;
                        }
                        else
                        {
                            throw new BusinessException("Customers result is empty");
                        }
                    }
                    catch (Exception ex)
                    {
                        throw new PlatformException(ex.Message, ex);
                    }
                }
            }
        }

        /**
            Crea un nuevo cliente
        */
        public string createCustomer(Customer customer)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("INSERT INTO [customers].dbo.customer (Id, first_name, last_name, phone_number, ");
            sql.Append("email, creditcard_number, creditcard_type, status ) VALUES ( @Id, ");
            sql.Append("@first_name, @last_name, @phone_number, @email, @creditcard_number, ");
            sql.Append("@creditcard_type, @status)");

            using (SqlConnection connection = new SqlConnection())
            {
                connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;
                SqlTransaction transaction;

                try
                {
                    connection.Open();
                    transaction = connection.BeginTransaction();

                    using (SqlCommand command = new SqlCommand(sql.ToString(), connection, transaction))
                    {
                        command.Parameters.Add("@Id", SqlDbType.NVarChar).Value = customer.Id;
                        command.Parameters.Add("@first_name", SqlDbType.NVarChar).Value = customer.first_name;
                        command.Parameters.Add("@last_name", SqlDbType.NVarChar).Value = customer.last_name;
                        command.Parameters.Add("@phone_number", SqlDbType.NVarChar).Value = customer.phone_number;
                        command.Parameters.Add("@email", SqlDbType.NVarChar).Value = customer.email;
                        command.Parameters.Add("@creditcard_number", SqlDbType.NVarChar).Value = customer.creditcard_number;
                        command.Parameters.Add("@creditcard_type", SqlDbType.NVarChar).Value = customer.creditcard_type;
                        command.Parameters.Add("@status", SqlDbType.NVarChar).Value = customer.status;

                        command.ExecuteNonQuery();

                        createCustomerAddress(customer.Id, customer.address, connection, transaction);

                        transaction.Commit();
                    }

                }
                catch (Exception ex)
                {
                    throw new PlatformException(ex.Message);
                }
            }

            return "OK";
        }

        /**
            Crea las direcciones asociadas a un cliente
        */
        private void createCustomerAddress(string customer_id, IList<Address> addresses, 
            SqlConnection connection, SqlTransaction transaction)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("INSERT INTO [customers].dbo.address (Id, street, state, zip, country, address_type, city) ");
            sql.Append("SELECT NEXT VALUE FOR [customers].dbo.seq_address, @street, @state, @zip, @country, @address_type, @city");

            StringBuilder sqlCustomerAddress = new StringBuilder();
            sqlCustomerAddress.Append("INSERT INTO [customers].dbo.customer_address (address_id, customer_id) ");
            sqlCustomerAddress.Append("SELECT CONVERT(bigint,current_value), @customer_id FROM sys.sequences WHERE name = 'seq_address'");


            using (SqlCommand command = new SqlCommand(sql.ToString(), connection, transaction))
            {
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

                    command.CommandText = sqlCustomerAddress.ToString();

                    command.ExecuteNonQuery();
                }
            }
        }

        /**
            Permite eliminar un cliente
        */
        public string deleteCustomer(string id)
        {
            string deleteCustomer = "DELETE FROM [customers].dbo.customer WHERE Id = @Id";

            SqlTransaction transaction;
            using (SqlConnection connection = new SqlConnection())
            {
                connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;

                try
                {
                    connection.Open();
                    transaction = connection.BeginTransaction();
                    deleteCustomerAddress(id, connection, transaction);

                    using (SqlCommand command = new SqlCommand(deleteCustomer, connection, transaction))
                    {
                        command.Parameters.Add("@Id", SqlDbType.NVarChar).Value = id;

                        command.ExecuteNonQuery();
                        transaction.Commit();
                    }
                }
                catch (Exception e)
                {
                    throw new PlatformException(e.Message);
                }
            }

            return "OK";
        }

        /**
            Elimina las direcciones asociadas al cliente
        */
        private void deleteCustomerAddress(string customer_id, 
            SqlConnection connection, SqlTransaction transaction)
        {
            StringBuilder deleteAddress = new StringBuilder();
            deleteAddress.Append("DELETE ad FROM [customers].dbo.address ad INNER JOIN ");
            deleteAddress.Append("[customers].[dbo].[customer_address] as ca ON ca.address_id = ad.Id ");
            deleteAddress.Append("WHERE ca.customer_id = @Id");

            using (SqlCommand command = new SqlCommand(deleteAddress.ToString(), connection, transaction))
            {
                command.Parameters.Add("@Id", SqlDbType.NVarChar).Value = customer_id;
                command.ExecuteNonQuery();
            }
        }

        /**
            Actualiza los datos principales de un cliente
        */
        public string updateCustomer(Customer customer)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("UPDATE [customers].dbo.customer SET first_name = @first_name, last_name = @last_name, ");
            sql.Append("phone_number = @phone_number, email = @email, ");
            sql.Append("creditcard_number = @creditcard_number, creditcard_type = @creditcard_type, status = @status ");
            sql.Append("WHERE Id = @Id");

            using (SqlConnection connection = new SqlConnection())
            {
                try
                {
                    connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;
                    connection.Open();

                    using (SqlCommand command = new SqlCommand(sql.ToString(), connection))
                    {
                        command.Parameters.Add("@Id", SqlDbType.NVarChar).Value = customer.Id;
                        command.Parameters.Add("@first_name", SqlDbType.NVarChar).Value = customer.first_name;
                        command.Parameters.Add("@last_name", SqlDbType.NVarChar).Value = customer.last_name;
                        command.Parameters.Add("@phone_number", SqlDbType.NVarChar).Value = customer.phone_number;
                        command.Parameters.Add("@email", SqlDbType.NVarChar).Value = customer.email;
                        command.Parameters.Add("@creditcard_number", SqlDbType.NVarChar).Value = customer.creditcard_number;
                        command.Parameters.Add("@creditcard_type", SqlDbType.NVarChar).Value = customer.creditcard_type;
                        command.Parameters.Add("@status", SqlDbType.NVarChar).Value = customer.status;

                        command.ExecuteNonQuery();

                        return "OK";
                    }
                }
                catch (Exception ex)
                {
                    throw new PlatformException(ex.Message);
                }
            }
        }
    }
}