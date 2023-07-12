package org.crud.example.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  private int id;
  @NotEmpty(message = "name not be empty")
  @Size(min = 2, max = 30, message = "name should be 2 and 30 character")
  private String name;
  @Min(value = 0, message = "age should be greater than 0")
  private int age;
  @NotEmpty(message = "Email should not be empty")
  @Email(message = "Email should be valid")
  private String email;
}
