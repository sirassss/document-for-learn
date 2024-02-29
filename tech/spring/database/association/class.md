## @ManyToOne

- Hibernate sẽ tự gen khóa ngoại nếu muốn đặt tên thì có thể dùng `@JoinColumn(name = "fk_order")`
- có cách sử dụng ánh xạ 2 chiếu là dùng chung với `@OneToMany` và dùng thuộc tính mappedBy là thuộc tính của entity bên
  kia để ánh xạ lại

## @ManyToMany

- Hibernate sẽ tự tạo bảng kết nốt nếu như không chỉ định rõ ràng
- có thể sử dụng `@JoinTable` để chỉ định bảng kết nối
  - `joinColumns` – Chỉ định tên khóa ngoại tham chiếu đến bảng sở hữu thuộc tính ánh xạ..
  - `inverseColumns` – Chỉ định tên khóa ngoại tham chiếu đến bảng được liên kết.
- VD:

```java
@Entity
public class Store {
  @ManyToMany
  @JoinTable(name = "store_product",
          joinColumns = { @JoinColumn(name = "fk_store") }, // fk_store là trường trong bảng store_product
          inverseJoinColumns = { @JoinColumn(name = "fk_product") }) // fk_product cũng tương tự
  private Set<Product> products = new HashSet<>();
  // ...
}
```
- Có thể sử dụng mappedBy để map 2 chiều nhưng khi xóa thì cần xóa ở 2 nơi để đảm bảo nhất quán

## @OneToOne

- cách dùng giống với 2 annotation trên