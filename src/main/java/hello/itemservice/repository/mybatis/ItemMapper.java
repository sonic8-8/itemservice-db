package hello.itemservice.repository.mybatis;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    void save(Item item);

    void update(@Param("id") Long id, @Param("updateParam")ItemUpdateDto updateParam);

    // 인터페이스에서 query 작성 가능하지만 이러면 MyBatis의 장점을 살리지 못함
//    @Select("select id, item_name, price, quantity from item where id = #{id}")
    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond itemSearch);
}
