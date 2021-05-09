package com.example.readingisgoodapi.controller;

import com.example.readingisgoodapi.base.BaseIT;
import com.example.readingisgoodapi.entity.OrderEntity;
import com.example.readingisgoodapi.repository.OrderEntityRepository;
import com.example.readingisgoodapi.service.ViewOrderDetailService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
public class ApiControllerIT extends BaseIT {

    @MockBean
    private ViewOrderDetailService viewOrderDetailService;
    @MockBean
    private OrderEntityRepository orderEntityRepository;

    @Captor
    private ArgumentCaptor<OrderEntity> orderEntityArgumentCaptor;

    @Test
    public void it_should_list_view_order_details() throws Exception {

        //given
        OrderEntity orderEntity = new OrderEntity(1L, 1L, 1L, 1L, LocalDateTime.now(), true);
        given(orderEntityRepository.findById(1L)).willReturn(Optional.of(orderEntity));

        //when
        ResultActions expectedResult = mockMvc.perform(get("/view-order-details" + "?orderId=1L")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print());

        //then
        expectedResult.andExpect(status().is2xxSuccessful());
        expectedResult.andExpect(jsonPath("$.customerId").value(1L));
        expectedResult.andExpect(jsonPath("$.addressId").value(1L));
        expectedResult.andExpect(jsonPath("$.bookId").value(1L));
    }

}
