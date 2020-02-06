Feature: Board logic works

  Scenario: Robot can move
    Given an empty 2x2 board
    Given a robot "0" placed at (0, 0), facing right
    When robot "0" moves forward
    Then robot "0" has position (1, 0)

  Scenario Outline: Robot can't move through walls
    Given a 2x2 board with the following objects:
      | Wall | <Position> |
    Given a robot "0" placed at (0, 0), facing right
    When robot "0" moves forward
    Then robot "0" has position (0, 0)

    Examples:
      | Position        |
      | right of (0, 0) |
      | left of (1, 0)  |

  Scenario: Robot is removed after moving off board
    Given an empty 1x1 board
    Given a robot "0" placed at (0, 0), facing right
    When robot "0" moves forward
    Then robot "0" does not exist

  Scenario: Robot can push other robot
    Given an empty 4x4 board
    Given a robot "1" placed at (0, 0), facing right
    Given a robot "2" placed at (1, 0)
    When robot "1" moves forward
    Then robot "1" has position (1, 0)
    Then robot "2" has position (2, 0)

  Scenario: Robot cant push TWO other robots simultaneously
    Given an empty 4x4 board
    Given a robot "1" placed at (0, 0), facing right
    Given a robot "2" placed at (1, 0)
    Given a robot "2" placed at (2, 0)
    When robot "1" moves forward
    Then robot "1" has position (0, 0)
    Then robot "2" has position (1, 0)
    Then robot "3" has position (2, 0)

