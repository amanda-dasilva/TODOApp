# TODO App

## Overview

This Java project is a simple TODO application designed to help users manage projects and tasks effectively. It allows for the creation, retrieval, updating, and deletion (CRUD) of projects and tasks. Additionally, it enforces the rule that each task must belong to a project.

## Entities

The application revolves around two main entities:

- **Projects**: These represent high-level categories or initiatives that tasks are organized under.
- **Tasks**: These are individual to-do items that belong to specific projects.

## Requirements

To run this application, you'll need the following:

- Java MVC Framework
- MySQL Database

## Business Rules

1. A task must belong to a project. This ensures that tasks are organized and associated with specific initiatives or categories.

## Technologies

- **Java MVC**: This project follows the Model-View-Controller (MVC) architectural pattern to separate concerns and ensure maintainability.
- **MySQL Database**: MySQL is used to store project and task data, providing a reliable and structured storage solution.

## Java Source Packages

The project is structured into several Java source packages, each serving a specific purpose:

- **Controller**: Contains controllers responsible for handling project and task operations.
  - `ProjectController`: Manages project-related actions.
  - `TaskController`: Handles task-related operations.

- **Model**: Contains model classes that define the structure of projects and tasks.
  - `Project`: Represents project entities.
  - `Task`: Defines the structure of tasks.

- **Util**: Contains utility classes for rendering, database connections, and table models.
  - `ButtonColumnCellRenderer`: Utility for rendering buttons in table cells.
  - `ConnectionFactory`: Manages database connections.
  - `DueDateRenderer`: Renders due dates in a specific format.
  - `TaskTableModel`: Custom table model for task data.

- **View**: Contains GUI components and screens.
  - `MainScreen`: The main application interface.
  - `ProjectDialogScreen`: Dialog for creating or editing projects.
  - `TaskDialogScreen`: Dialog for creating or editing tasks.

## Getting Started

To get started with this TODO app, follow these steps:

1. Set up a MySQL database and configure the connection settings in `ConnectionFactory.java`.
2. Run the `Main.java` class to start the application.
3. Use the application to create, view, update, and delete projects and tasks.


## Installation Instructions

### Prerequisites

Before you begin, make sure you have the following prerequisites installed:

1. **Java Development Kit (JDK):**
   - Ensure you have Java JDK 8 or later installed on your system. You can download it from the [Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html) or use OpenJDK.

2. **MySQL Database:**
   - Set up a MySQL database to store project and task data. You should have the database server running and know the database connection details (e.g., host, port, username, password).

### Steps

Follow these steps to install and run your "TODO App" Java project:

1. **Clone the Repository:**
   Clone the project repository to your local machine using Git:

   ```bash
   git clone <repository-url>
   ```

2. **Configure Database Connection:**
   - Open the `ConnectionFactory.java` file located in the `Util` package.
   - Modify the database connection settings to match your MySQL database configuration (e.g., host, port, username, password).

3. **Build the Project:**
   - Navigate to the root folder of the project in your terminal.
   - Compile the Java source code by running:

   ```bash
   javac -d bin src/*.java
   ```

4. **Run the Application:**
   - Start the application by running the `Main` class:

   ```bash
   java -cp bin Main.Main
   ```

5. **Use the Application:**
   - The application's main interface, `MainScreen`, should now be displayed.
   - You can create, view, update, and delete projects and tasks using the GUI.

### Usage Tips

- Projects and tasks are organized in the application, and tasks must be associated with a project.
- You can create, edit, or delete projects and tasks using the provided GUI dialogs.

### Contributing

Contributions are welcome! If you have any ideas, suggestions, or improvements, please feel free to open an issue or submit a pull request.
