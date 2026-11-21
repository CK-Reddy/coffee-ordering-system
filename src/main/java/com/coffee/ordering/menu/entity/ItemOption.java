package com.coffee.ordering.menu.entity;

//import com.sun.tools.javac.main.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item_options")
@Getter
@Setter
@NoArgsConstructor
public class ItemOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OptionKind kind;

    private String name;

    private BigDecimal priceDelta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;


}
