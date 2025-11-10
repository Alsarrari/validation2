package com.SpringBootExerciseEvent.validation.Controller;

import com.SpringBootExerciseEvent.validation.Model.Event;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    ArrayList<Event>events=new ArrayList<>();
    @GetMapping("get")
    private ResponseEntity getEvent(){
        return ResponseEntity.ok(events);
    }
    @PostMapping("/add")
    public ResponseEntity addEvent(@RequestBody @Valid Event event){
        events.add(event);
        return ResponseEntity.ok("event add");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity upDate(@PathVariable String id ,@RequestBody @Valid Event event){
        for (int i=0; i<events.size();i++){
            if (events.get(i).getId().equals(id)){
                events.set(i,event);
                return ResponseEntity.ok("event update");
            }
        }
        return ResponseEntity.badRequest().body("event invalid");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEvent(@PathVariable @Valid String id  ,  @RequestParam int cap){
events.remove(id);
return ResponseEntity.ok("event delete");
    }

    @PutMapping("/capacity/{id}")
    public ResponseEntity changeCapacity(@PathVariable String id, @RequestParam int cap) {

        for (Event e : events) {
            if (e.getId().equals(id)) {
                return ResponseEntity.ok("Capacity Updated");
            }
        }

        return ResponseEntity.badRequest().body("Event Not Found");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchEvent(@PathVariable String id) {

        for (Event e : events) {
            if (e.getId().equals(id)) {
                return ResponseEntity.ok(e);
            }
        }

        return ResponseEntity.badRequest().body("Event Not Found");
    }
}


