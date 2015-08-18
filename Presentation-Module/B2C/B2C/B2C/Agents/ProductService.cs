using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;

namespace B2C.Agents
{
    public class ProductService
    {

        public Product getProduct(int id)
        {
            Product product = new Product(1, "Producto 5", "http://ecx.images-amazon.com/images/I/81Tsd0nZ39L._SL1500_.jpg", "Descripcion del producto");
            return product;
        }

        public List<Product> getProducts()
        {
            List<Product> products = new List<Product>();

            int i = 0;
            Product p;

            for (i = 0; i <= 20; i++)
            {
                p = new Product(i, "Producto " + i, "http://ecx.images-amazon.com/images/I/81Tsd0nZ39L._SL1500_.jpg", "Descripcion del producto " + i);
                products.Add(p);
            }

            return products;

        }

        public List<Product> getTopFive(int product)
        {
            List<Product> products = new List<Product>();

            int i = 0;
            Product p;

            for (i = 0; i < 5; i++)
            {
                p = new Product(i, "Producto " + i, "http://ecx.images-amazon.com/images/I/81Tsd0nZ39L._SL1500_.jpg", "Descripcion del producto " + i);
                products.Add(p);
            }

            return products;
        }

    }
}