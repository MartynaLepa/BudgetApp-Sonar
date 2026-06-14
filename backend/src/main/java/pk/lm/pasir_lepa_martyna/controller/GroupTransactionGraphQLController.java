package pk.lm.pasir_lepa_martyna.controller;

import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import pk.lm.pasir_lepa_martyna.dto.GroupTransactionDTO;
import pk.lm.pasir_lepa_martyna.service.GroupTransactionService;

@Controller
public class GroupTransactionGraphQLController {

    private final GroupTransactionService groupTransactionService;

    public GroupTransactionGraphQLController(GroupTransactionService groupTransactionService) {
        this.groupTransactionService = groupTransactionService;
    }

    @MutationMapping
    public Boolean addGroupTransaction(@Valid @Argument GroupTransactionDTO groupTransactionDTO) {
        return groupTransactionService.addGroupTransaction(groupTransactionDTO);
    }
}