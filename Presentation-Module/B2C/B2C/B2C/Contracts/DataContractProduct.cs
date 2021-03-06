﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Newtonsoft.Json;
using System.Runtime.Serialization;
using B2C.Entities;

namespace B2C.Contracts
{

    public class DataContractOrder
    {
        [JsonProperty("id")]
        public int id { get; set; }

        [JsonProperty("price")]
        public double price { get; set; }

        [JsonProperty("status")]
        public string status { get; set; }

        [JsonProperty("comments")]
        public string comments { get; set; }

    }

    public class DataContractItemOrder
    {
        [JsonProperty("id")]
        public int id { get; set; }

        [JsonProperty("productId")]
        public int productId { get; set; }

        [JsonProperty("productName")]
        public string productName { get; set; }

        [JsonProperty("partnum")]
        public int partnum { get; set; }

        [JsonProperty("price")]
        public double price { get; set; }

        [JsonProperty("quantity")]
        public int quantity { get; set; }
    }

    public class DataContractProduct
    {
        [JsonProperty("id")]
        public int id { get; set; }

        [JsonProperty("name")]
        public String name { get; set; }

        [JsonProperty("description")]
        public String description { get; set; }

        [JsonProperty("code")]
        public String code { get; set; }

        [JsonProperty("price")]
        public double price { get; set; }

        [JsonProperty("spectacleDate")]
        public DateTime spectacleDate { get; set; }


        [JsonProperty("arrivalDate")]
        public DateTime arrivalDate { get; set; }

        [JsonProperty("departureDate")]
        public DateTime departureDate { get; set; }


        [JsonProperty("imageRef", NullValueHandling = NullValueHandling.Ignore)]
        public byte[] imageRef { get; set; }

        [JsonProperty("transportType", NullValueHandling = NullValueHandling.Ignore)]
        public DataContractType transportType { get; set; }


        [JsonProperty("spectacleType", NullValueHandling = NullValueHandling.Ignore)]
        public DataContractType spectacleType { get; set; }


        [JsonProperty("lodgingType", NullValueHandling = NullValueHandling.Ignore)]
        public DataContractType lodgingType { get; set; }

        
        [JsonProperty("sourceCity", NullValueHandling = NullValueHandling.Ignore)]
        public DataContractCity sourceCity { get; set; }


        [JsonProperty("targetCity", NullValueHandling = NullValueHandling.Ignore)]
        public DataContractCity targetCity { get; set; }

        

    }

    public class DataContractCount
    {
        [JsonProperty("total")]
        public int total { get; set; }
    }

    public class DataContractType
    {
        [JsonProperty("id", NullValueHandling = NullValueHandling.Ignore)]
        public int id { get; set; }

        [JsonProperty("name", NullValueHandling = NullValueHandling.Ignore)]
        public string name { get; set; }


        [JsonProperty("cost", NullValueHandling = NullValueHandling.Ignore)]
        public double cost { get; set; }

        [JsonProperty("travelDate", NullValueHandling = NullValueHandling.Ignore)]
        public DateTime travelDate { get; set; }


        [JsonProperty("travelOutTime", NullValueHandling = NullValueHandling.Ignore)]
        public int travelOutTime { get; set; }

        [JsonProperty("businessProvider", NullValueHandling = NullValueHandling.Ignore)]
        public string businessProvider { get; set; }
    }

    public class DataContractTopFive
    {
        [JsonProperty("idProduct", NullValueHandling = NullValueHandling.Ignore)]
        public int idProduct { get; set; }

        [JsonProperty("nameProduct", NullValueHandling = NullValueHandling.Ignore)]
        public string nameProduct { get; set; }
    }

    public class DataContractCity
    {
        [JsonProperty("name", NullValueHandling = NullValueHandling.Ignore)]
        public String name { get; set; }


        [JsonProperty("id", NullValueHandling = NullValueHandling.Ignore)]
        public int id { get; set; }
    }

    public class DataContractProductSmall
    {
        [JsonProperty("id", NullValueHandling = NullValueHandling.Ignore)]
        public int id { get; set; }
    }


    public class DataContractCampaigns
    {
        
        [JsonProperty("id")]
        public int id { get; set; } 

        [JsonProperty("name")]
        public String name { get; set; }

        [JsonProperty("imageRef")]
        public byte[] imageRef { get; set; }

        [JsonProperty("product")]
        public DataContractProductSmall product { get; set; }
       
    }
}