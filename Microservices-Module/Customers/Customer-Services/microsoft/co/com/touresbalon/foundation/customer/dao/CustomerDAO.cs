using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Configuration;
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
            sql.Append("creditcard_number, creditcard_type, status FROM CUSTOMERS.CUSTOMER WHERE Id=:id");

            Customer customer = new Customer();
            
            using (OracleConnection connection = new OracleConnection())
            {
               connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;

                using (OracleCommand command = new OracleCommand(sql.ToString(), connection))
                {
                    command.Parameters.Add(new OracleParameter("id", id));
                    connection.Open();

                    try
                    {
                        OracleDataReader reader = command.ExecuteReader();
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

        public Customer getCustomerByEmail(string email)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("SELECT Id, first_name, last_name, phone_number, email, ");
            sql.Append("creditcard_number, creditcard_type, status FROM CUSTOMERS.CUSTOMER WHERE email=:email");

            Customer customer = new Customer();

            using (OracleConnection connection = new OracleConnection())
            {
                connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;

                using (OracleCommand command = new OracleCommand(sql.ToString(), connection))
                {
                    command.Parameters.Add(new OracleParameter("email", email));
                    connection.Open();

                    try
                    {
                        OracleDataReader reader = command.ExecuteReader();
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
            sql.Append("(SELECT ROW_NUMBER()Over(Order by CUSTOMERS.CUSTOMER.first_name ASC) As RowNum, ");
            sql.Append("Id, first_name, last_name, phone_number, email, ");
            sql.Append("creditcard_number, creditcard_type, status FROM CUSTOMERS.CUSTOMER) AS Resultado ");
            sql.Append("WHERE RowNum BETWEEN (:pagina -1) * :regPagina + 1 AND :pagina * :regPagina");

            IList<Customer> customers = new List<Customer>();

            using (OracleConnection connection = new OracleConnection())
            {
                connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;

                using (OracleCommand command = new OracleCommand(sql.ToString(), connection))
                {

                    command.Parameters.Add(new OracleParameter("pagina", pagina));
                    command.Parameters.Add(new OracleParameter("regPagina", regPagina));

                    try
                    {
                        connection.Open();
                        OracleDataReader reader = command.ExecuteReader();

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
            sql.Append("INSERT INTO CUSTOMERS.CUSTOMER (Id, first_name, last_name, phone_number, ");
            sql.Append("email, creditcard_number, creditcard_type, status ) VALUES ( :Id, ");
            sql.Append(":first_name, :last_name, :phone_number, :email, :creditcard_number, ");
            sql.Append(":creditcard_type, :status)");

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
                        command.Parameters.Add(new OracleParameter("Id", customer.Id));
                        command.Parameters.Add(new OracleParameter("first_name", customer.first_name));
                        command.Parameters.Add(new OracleParameter("last_name", customer.last_name));
                        command.Parameters.Add(new OracleParameter("phone_number", customer.phone_number));
                        command.Parameters.Add(new OracleParameter("email", customer.email));
                        command.Parameters.Add(new OracleParameter("creditcard_number", customer.creditcard_number));
                        command.Parameters.Add(new OracleParameter("creditcard_type", customer.creditcard_type));
                        command.Parameters.Add(new OracleParameter("status", customer.status));

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
            OracleConnection connection, OracleTransaction transaction)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("INSERT INTO CUSTOMERS.ADDRESS (Id, street, state, zip, country, address_type, city) VALUES ");
            sql.Append("(CUSTOMERS.SEQ_ADDRESS.NEXTVAL, :street, :state, :zip, :country, :address_type, :city)");

            StringBuilder sqlCustomerAddress = new StringBuilder();
            sqlCustomerAddress.Append("INSERT INTO CUSTOMERS.CUSTOMER_ADDRESS (address_id, customer_id) VALUES ");
            sqlCustomerAddress.Append("(CUSTOMERS.SEQ_ADDRESS.CURRVAL, :customer_id)");


            using (OracleCommand command = new OracleCommand(sql.ToString(), connection))
            {
                foreach (Address address in addresses)
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
                        secondCommand.Parameters.Add(new OracleParameter("customer_id", customer_id));
                        secondCommand.ExecuteNonQuery();
                    }
                }
            }
        }

        /**
            Permite eliminar un cliente
        */
        public string deleteCustomer(string id)
        {
            string deleteCustomer = "DELETE FROM CUSTOMERS.CUSTOMER WHERE Id = :Id";

            OracleTransaction transaction;
            using (OracleConnection connection = new OracleConnection())
            {
                connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;

                try
                {
                    connection.Open();
                    transaction = connection.BeginTransaction();
                    deleteCustomerAddress(id, connection, transaction);

                    using (OracleCommand command = new OracleCommand(deleteCustomer, connection))
                    {
                        command.Parameters.Add(new OracleParameter("Id", id));

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
            OracleConnection connection, OracleTransaction transaction)
        {
            StringBuilder deleteAddress = new StringBuilder();
            deleteAddress.Append("DELETE ad FROM CUSTOMERS.ADDRESS ad INNER JOIN ");
            deleteAddress.Append("CUSTOMERS.CUSTOMER_ADDRESS as ca ON ca.address_id = ad.Id ");
            deleteAddress.Append("WHERE ca.customer_id = :Id");

            using (OracleCommand command = new OracleCommand(deleteAddress.ToString(), connection))
            {
                command.Parameters.Add(new OracleParameter("Id", customer_id));
                command.ExecuteNonQuery();
            }
        }

        /**
            Actualiza los datos principales de un cliente
        */
        public string updateCustomer(Customer customer)
        {
            StringBuilder sql = new StringBuilder();
            sql.Append("UPDATE CUSTOMERS.CUSTOMER SET first_name = :first_name, last_name = :last_name, ");
            sql.Append("phone_number = :phone_number, email = :email, ");
            sql.Append("creditcard_number = :creditcard_number, creditcard_type = :creditcard_type, status = :status ");
            sql.Append("WHERE Id = :Id");

            using (OracleConnection connection = new OracleConnection())
            {
                try
                {
                    connection.ConnectionString = ConfigurationManager.ConnectionStrings["customerDb"].ConnectionString;
                    connection.Open();

                    using (OracleCommand command = new OracleCommand(sql.ToString(), connection))
                    {
                        command.Parameters.Add(new OracleParameter("Id", customer.Id));
                        command.Parameters.Add(new OracleParameter("first_name", customer.first_name));
                        command.Parameters.Add(new OracleParameter("last_name", customer.last_name));
                        command.Parameters.Add(new OracleParameter("phone_number", customer.phone_number));
                        command.Parameters.Add(new OracleParameter("email", customer.email));
                        command.Parameters.Add(new OracleParameter("creditcard_number", customer.creditcard_number));
                        command.Parameters.Add(new OracleParameter("creditcard_type", customer.creditcard_type));
                        command.Parameters.Add(new OracleParameter("status", customer.status));

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