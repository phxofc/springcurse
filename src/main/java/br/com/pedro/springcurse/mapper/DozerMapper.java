package br.com.pedro.springcurse.mapper;

//import com.github.dozermapper.core.DozerBeanMapperBuilder;
//import com.github.dozermapper.core.Mapper;

import br.com.pedro.springcurse.data.model.Book;
import br.com.pedro.springcurse.data.model.Person;
import br.com.pedro.springcurse.data.vo.BookVO;
import br.com.pedro.springcurse.data.vo.PersonVO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
    //private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    private static ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(
                Person.class,
                PersonVO.class).addMapping(
                        Person::getId,PersonVO::setKey);

    }
    static {
        mapper.createTypeMap(
                Book.class,
                BookVO.class).addMapping(
                Book::getId,BookVO::setKey);

    }

    public static <O, D> D parseObject(O origin, Class<D> destination){
        return  mapper.map(origin,destination);

    }
    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination){
        List<D> destinationObjects = new ArrayList<D>();
        for (O o: origin) {
            destinationObjects.add(mapper.map(o,destination));
        }
        return  destinationObjects;

    }

}
