# API REST USERS MANAGEMENT

This Rest API developed in Spring Boot manages a database where there is users information that we can display, modify, create and delete through queries, whose execution can be tested through HTTP query software, the consumption of services of this API is done with Spring's built-in server.


#### URL for query for services
>
> - http://domain/api//users/findAll
> - http://domain/api//users/findById/id
> - http://domain/api//users/save
> - http://domain/api//update
> - http://domain/api//delete


Service routing `<find all users>`

    
	@GetMapping("/findAll")
     public ResponseEntity<List<UserDTO>> findAll() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
     }
    

Service routing `<Find user by id>`

    
    @GetMapping("/findById/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }
    

Service routing `<Save user>`

    
    @PostMapping("/save")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(this.userService.save(userDTO), HttpStatus.CREATED);
    }
    

Service routing `<Update user>`

    
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable Integer id) {
        return new ResponseEntity<>(this.userService.update(userDTO, id), HttpStatus.OK);
    }
    

Service routing `<Delete user>`

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(this.userService.delete(id), HttpStatus.NO_CONTENT);
    }
    }
    

#### Installation requirements

This API is supported in Java 21, therefore it is recommended to have the same or similar version.

For the database, this API only has a dependency for MySQL, therefore it is recommended that this be the database manager that is managed.

#### Versions
- Java version "21.0.2" 2024-01-16 LTS
- Spring Boot 3.4.2
- Maven technology
