package com.example.webapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private final TodoRepository todoRepository;
    private static int todosCount =0;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findByUsername(String username) {
        List<Todo> todos = todoRepository.findByUsername(username);
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todosCount,username, description,targetDate,done);
        todoRepository.save(todo);
    }

    public void deleteById(int id){
        boolean exists = todoRepository.existsById(id);
        if (!exists) throw new IllegalStateException("todo with id " + id + " does not exists");
        todoRepository.deleteById(id);
    }

    public Optional<Todo> findById(int id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todoRepository.save(todo);
    }
}
