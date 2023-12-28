package br.com.pedro.springcurse.controllers;

import br.com.pedro.springcurse.data.vo.PersonVO;
import br.com.pedro.springcurse.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin
@RestController
@RequestMapping("/person")
@Tag(name = "People", description = "Endpoins for Maneging People")
public class PersonController {


    @Autowired
    PersonServices personServices;


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}")
    @Operation(summary = "Finds A Person", description = "Finds A Person",

            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content =
                                    @Content(schema = @Schema(implementation = PersonVO.class))
                            ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
        return personServices.findById(id);
    }

    @GetMapping()
    @Operation(summary = "Finds All People", description = "Finds All People",

            responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
                    )
                    }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })

    public List<PersonVO> findByAll() throws Exception {
        return personServices.findAll();
    }

    @CrossOrigin(origins = {"http://localhost:8080","http://pedro.com.br"})
    @PostMapping()
    @Operation(summary = "create a person", description = "create A Person",

            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content =
                            @Content(schema = @Schema(implementation = PersonVO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public PersonVO create(@RequestBody PersonVO person) throws Exception {
        return personServices.create(person);
    }

    @PutMapping()
    @Operation(summary = "Modify A Person", description = "Modify A Person",

            responses = {
                    @ApiResponse(description = "Updated", responseCode = "200",
                            content =
                            @Content(schema = @Schema(implementation = PersonVO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public PersonVO update(@RequestBody PersonVO person) throws Exception {
        return personServices.update(person);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes A Person", description = "Deletes A Person",

            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content
                    ),

                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public void delete(@PathVariable(value = "id") Long id) throws Exception {
        personServices.delete(id);
    }


}
