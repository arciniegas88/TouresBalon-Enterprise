using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Text;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.dao
{
    public class AddressDAO
    {
        /**
            Obtienes las direcciones de un cliente
            */
        public IList<Address> getCustomerAddress(string customer_id)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("SELECT ad.Id, ad.street, ad.state, ad.zip, ad.country, ad.address_type, ad.city ");
            sql.Append("FROM [customers].dbo.address ad INNER JOIN [customers].dbo.customer_address cus ");
            sql.Append("ON ad.Id = cus.address_id WHERE cus.customer_id = @id");

            List<Address> addresses = new List<Address>();

            using (SqlConnection connection = new SqlConnection())
            {
                connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;

                using (SqlCommand command = new SqlCommand(sql.ToString(), connection))
                {
                    command.Parameters.Add("@id", SqlDbType.NVarChar).Value = customer_id;
                    connection.Open();

                    try
                    {
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
                        return addresses;
                    }
                    catch (Exception ex)
                    {
                        throw new PlatformException(ex.Message);
                    }
                }
            }
        }

        /**
            Permite actualizar una direccion
        */
        public string updateAddress(Address address)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("UPDATE [customers].dbo.address SET street = @street, state = @state, zip = @zip, ");
            sql.Append("country = @country, address_type = @address_type, city = @city ");
            sql.Append("WHERE Id = @id");

            using (SqlConnection connection = new SqlConnection())
            {
                try
                {
                    connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;
                    connection.Open();

                    using (SqlCommand command = new SqlCommand(sql.ToString(), connection))
                    {
                        command.Parameters.Add("@id", SqlDbType.Int).Value = address.Id;
                        command.Parameters.Add("@street", SqlDbType.NVarChar).Value = address.street;
                        command.Parameters.Add("@state", SqlDbType.NVarChar).Value = address.state;
                        command.Parameters.Add("@zip", SqlDbType.NVarChar).Value = address.zip;
                        command.Parameters.Add("@country", SqlDbType.NVarChar).Value = address.country;
                        command.Parameters.Add("@address_type", SqlDbType.NVarChar).Value = address.address_type;
                        command.Parameters.Add("@city", SqlDbType.NVarChar).Value = address.city;

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

        public string addAddress(string customer_id, Address address)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("INSERT INTO [customers].dbo.address (Id, street, state, zip, country, address_type, city) ");
            sql.Append("SELECT NEXT VALUE FOR [customers].dbo.seq_address, @street, @state, @zip, @country, @address_type, @city");

            StringBuilder sqlCustomerAddress = new StringBuilder();
            sqlCustomerAddress.Append("INSERT INTO [customers].dbo.customer_address (address_id, customer_id) ");
            sqlCustomerAddress.Append("SELECT CONVERT(bigint,current_value), @customer_id FROM sys.sequences WHERE name = 'seq_address'");

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

                        transaction.Commit();
                    }
                    return "OK";
                }
                catch (Exception ex)
                {
                    throw new PlatformException(ex.Message);
                }
            }
        }

        public string deleteAddress(string id, string customer_id)
        {
            StringBuilder deleteCustomerAddress = new StringBuilder();
            deleteCustomerAddress.Append("DELETE FROM [customers].dbo.customer_address ");
            deleteCustomerAddress.Append("WHERE customer_id = @customer_id AND address_id = @Id");

            StringBuilder deleteAddress = new StringBuilder();
            deleteAddress.Append("DELETE FROM [customers].dbo.address ");
            deleteAddress.Append("WHERE Id = @Id");

            SqlTransaction transaction;
            using (SqlConnection connection = new SqlConnection())
            {
                connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;

                connection.Open();
                transaction = connection.BeginTransaction();

                using (SqlCommand command = new SqlCommand(deleteCustomerAddress.ToString(), connection, transaction))
                {
                    command.Parameters.Add("@Id", SqlDbType.Int).Value = id;
                    command.Parameters.Add("@customer_id", SqlDbType.NVarChar).Value = customer_id;

                    try
                    {
                        command.ExecuteNonQuery();
                        command.CommandText = deleteAddress.ToString();
                        command.ExecuteNonQuery();

                        transaction.Commit();

                        return "OK";

                    }
                    catch (Exception e)
                    {
                        throw new PlatformException(e.Message);
                    }
                }
            }
        } 
    }
}