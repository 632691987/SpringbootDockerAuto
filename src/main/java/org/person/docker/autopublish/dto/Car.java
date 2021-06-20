package org.person.docker.autopublish.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class Car {

  private int id;

  @Min(12)
  @Max(96)
  private int value;

  @Range(min = 512, max = 1024)
  private int miles;

  @NotNull(message = "Name cannot be null")
  private String name;

  @NotNull(message = "Version cannot be null")
  private String version;

  @Email(regexp=".*@.*\\..*", message = "Email should be valid")
  private String email;

  public Car(String name, String version) {
    this.name = name;
    this.version = version;
  }
}
