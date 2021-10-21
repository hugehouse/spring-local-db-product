package com.test.whatap.domain;

import com.test.whatap.util.TimeFormatter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Product implements Entity {

    // 데이터베이스에서 자동으로 입력되기 때문에 검증하지 않음. 추후 수정
    private Long id;

//    @NotNull(message = "가격을 입력해 주세요.")
    @Min(value = 1, message = "가격은 1 이상으로 입력해 주세요.")
    @Max(value = 1000000000, message = "가격은 1,000,000,000 이하로 입력해 주세요.")
    private int price;

    // NotNull이 제대로 기능하지 않음
    @Min(value = 1, message = "카테고리를 선택해 주세요.")
    private int category;

    @Min(value = 1, message = "재고를 입력해 주세요.")
    private int stock;

    @Length(max = 30, message = "상품명은 30글자 이내로 적어주세요.")
    @NotBlank(message = "상품명을 입력해 주세요.")
    private String title;

    private String createdTime;

    private String thumbnailImage;

    private String bodyImage;

    @Builder
    public Product(Long id, String title, int price, int category,
                   int stock, String createdTime, String thumbnailImage, String bodyImage){
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.createdTime = createdTime;
        this.thumbnailImage = thumbnailImage;
        this.bodyImage = bodyImage;
    }

    public void update(String title, int price, int category, int stock, String thumbnailImage, String bodyImage) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.thumbnailImage = thumbnailImage;
        this.bodyImage = bodyImage;
    }

    public String setLocalDateTime() {
        return TimeFormatter.formTime(LocalDateTime.now());
    }
    public void setImage(String thumbnailImage, String bodyImage) {
        this.thumbnailImage = thumbnailImage;
        this.bodyImage = bodyImage;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
