package no.bliutvikler.bliutvikler;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private final TodoRepository repository;

    TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    // get all todos
    @CrossOrigin(origins = {"http://localhost:3000", "https://sloppy-room-production.up.railway.app"})
    @GetMapping("/todo")
    List<Todo> all() {
        return repository.findAll();
    }

    // create a new todo
    @CrossOrigin(origins = {"http://localhost:3000", "https://sloppy-room-production.up.railway.app"})
    @PostMapping("/todo")
    Todo newTodo(@RequestBody Todo newTodo) {
        return repository.save(newTodo);
    }

    // get singe todo
    @CrossOrigin(origins = {"http://localhost:3000", "https://sloppy-room-production.up.railway.app"})
    @GetMapping("/todo/{id}")
    Todo one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    // update todo
    @CrossOrigin(origins = {"http://localhost:3000", "https://sloppy-room-production.up.railway.app"})
    @PutMapping("/todo/{id}")
    Todo replaceTodo(@RequestBody Todo newTodo, @PathVariable Long id) {
        return repository.findById(id)
                .map(todo -> {
                    todo.setTitle(newTodo.getTitle());
                    todo.setCompleted(newTodo.getCompleted());
                    return repository.save(todo);
                })
                .orElseGet(() -> {
                    newTodo.setId(id);
                    return repository.save(newTodo);
                });
    }

    // delete todo
    @CrossOrigin(origins = {"http://localhost:3000", "https://sloppy-room-production.up.railway.app"})
    @DeleteMapping("/todo/{id}")
    void deleteTodo(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
