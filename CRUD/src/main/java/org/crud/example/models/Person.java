package org.crud.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  private int id;
  private String name;
  private int age;
  private String email;
}
