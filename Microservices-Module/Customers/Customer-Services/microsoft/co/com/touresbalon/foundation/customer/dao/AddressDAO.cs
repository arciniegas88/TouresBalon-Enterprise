using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Configuration;
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
            sql.Append("FROM CUSTOMERS.ADDRESS ad INNER JOIN CUSTOMERS.CUSTOMER_ADDRESS cus ");
            sql.Append("ON ad.Id = cus.address_id WHERE cus.customer_id = :id");

            List<Address> addresses = new List<Address>();

            using (OracleConnection connection = new OracleConnection())
            {
                connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;

                using (OracleCommand command = new OracleCommand(sql.ToString(), connection))
                {
                    command.Parameters.Add(new OracleParameter("id", customer_id));
                    connection.Open();

                    try
                    {
                        OracleDataReader reader = command.ExecuteReader();

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
            sql.Append("UPDATE CUSTOMERS.ADDRESS SET street = :street, state = :state, zip = :zip, ");
            sql.Append("country = :country, address_type = :address_type, city = :city ");
            sql.Append("WHERE Id = :id");

            using (OracleConnection connection = new OracleConnection())
            {
                try
                {
                    connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;
                    connection.Open();

                    using (OracleCommand command = new OracleCommand(sql.ToString(), connection))
                    {
                        command.Parameters.Add(new OracleParameter("id", address.Id));
                        command.Parameters.Add(new OracleParameter("street", address.street));
                        command.Parameters.Add(new OracleParameter("state", address.state));
                        command.Parameters.Add(new OracleParameter("zip", address.zip));
                        command.Parameters.Add(new OracleParameter("country", address.country));
                        command.Parameters.Add(new OracleParameter("address_type", address.address_type));
                        command.Parameters.Add(new OracleParameter("city", address.city));

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
            sql.Append("INSERT INTO CUSTOMERS.ADDRESS (Id, street, state, zip, country, address_type, city) VALUES");
            sql.Append("(CUSTOMERS.SEQ_ADDRESS.NEXTVAL, :street, :state, :zip, :country, :address_type, :city)");

            StringBuilder sqlCustomerAddress = new StringBuilder();
            sqlCustomerAddress.Append("INSERT INTO CUSTOMERS.CUSTOMER_ADDRESS (address_id, customer_id) VALUES");
            sqlCustomerAddress.Append("(CUSTOMERS.SEQ_ADDRESS.CURRVAL, :customer_id)");

            using (OracleConnection connection = new OracleConnection())
            {
                connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;
                OracleTransaction transaction;

                try
                {
                    connection.Open();
                    transaction = connection.BeginTransaction();

                    using (OracleCommand command = new OracleCommand(sql.ToString(), connection))
                    {
                        command.Parameters.Add(new OracleParameter("street", address.street));
                        command.Parameters.Add(new OracleParameter("state", address.state));
                        command.Parameters.Add(new OracleParameter("zip", address.zip));
                        command.Parameters.Add(new OracleParameter("country", address.country));
                        command.Parameters.Add(new OracleParameter("address_type", address.address_type));
                        command.Parameters.Add(new OracleParameter("city", address.city));

                        command.ExecuteNonQuery();

                        using (OracleCommand secondCommand = new OracleCommand(sqlCustomerAddress.ToString(), connection))
                        {
                            secondCommand.CommandText = sqlCustomerAddress.ToString();
                            secondCommand.Parameters.Add(new OracleParameter("customer_id", customer_id));
                            secondCommand.ExecuteNonQuery();
                        }

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
            deleteCustomerAddress.Append("DELETE FROM CUSTOMERS.CUSTOMER_ADDRESS ");
            deleteCustomerAddress.Append("WHERE customer_id = :customer_id AND address_id = :Id");

            StringBuilder deleteAddress = new StringBuilder();
            deleteAddress.Append("DELETE FROM CUSTOMERS.ADDRESS ");
            deleteAddress.Append("WHERE Id = :Id");

            OracleTransaction transaction;
            using (OracleConnection connection = new OracleConnection())
            {
                connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;

                connection.Open();
                transaction = connection.BeginTransaction();

                using (OracleCommand command = new OracleCommand(deleteCustomerAddress.ToString(), connection))
                {
                    command.Parameters.Add(new OracleParameter("Id", id));

                    try
                    {
                        command.ExecuteNonQuery();

                        using(OracleCommand secondCommand = new OracleCommand(deleteAddress.ToString(), connection))
                        {
                            secondCommand.CommandText = deleteAddress.ToString();
                            secondCommand.Parameters.Add(new OracleParameter("customer_id", customer_id));
                            secondCommand.ExecuteNonQuery();
                        }

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