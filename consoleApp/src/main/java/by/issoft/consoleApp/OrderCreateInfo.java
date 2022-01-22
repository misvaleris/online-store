package by.issoft.consoleApp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
public class OrderCreateInfo {
    private Set<Long> productIds = new HashSet<>();
}
