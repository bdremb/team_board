package by.example.team_board.exceptions;

public class PersonAlreadyExistException extends Exception {
  public PersonAlreadyExistException(String message) {
    super(message);
  }
}
