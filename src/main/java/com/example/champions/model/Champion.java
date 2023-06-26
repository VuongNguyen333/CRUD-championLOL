package com.example.champions.model;

import jakarta.persistence.*;

@Entity
public class Champion {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(nullable = false, updatable = false)
   private Long id;
   private String name;
   private String address;
   private String imageUrl;

   public Champion() {
   }

   public Champion(Long id, String name, String address, String imageUrl) {
      this.id = id;
      this.name = name;
      this.address = address;
      this.imageUrl = imageUrl;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getImageUrl() {
      return imageUrl;
   }

   public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
   }

   @Override
   public String toString() {
      return "Champion{" +
             "id=" + id +
             ", name='" + name + '\'' +
             ", address='" + address + '\'' +
             ", imageUrl='" + imageUrl + '\'' +
             '}';
   }
}
