package com.springtesting.mockito;


import com.springtesting.model.OrderDetail;
import com.springtesting.model.OrderDetailProduct;
import com.springtesting.model.UserProfile;
import com.springtesting.repo.OrderDetailProductRepository;
import com.springtesting.repo.OrderDetailRepository;
import com.springtesting.repo.UserProfileRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(value = "integrationtest")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderDetailControllerTest
{
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailProductRepository orderDetailProductRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    private UserProfile userProfile;

    @Before
    public void setUp()
    {
        this.userProfile=findUserProfile();
    }


    @Test
    public void createOrder()
    {
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setAddress(this.userProfile.getAddresses().get(0));
        orderDetail.setPurchasedBy(this.userProfile);
        orderDetail.setId("ord1001");
        orderDetailRepository.saveAndFlush(orderDetail);
        addProductsToOrder(orderDetail);
    }

    private void addProductsToOrder(OrderDetail orderDetail)
    {
        OrderDetailProduct orderDetailProduct=new OrderDetailProduct();
        orderDetailProduct.setId(1001);
        orderDetailProduct.setOrderDetailId(orderDetail.getId());
        orderDetailProduct.setProductListId("p1001");
        orderDetailProductRepository.saveAndFlush(orderDetailProduct);

        orderDetailProduct=new OrderDetailProduct();
        orderDetailProduct.setId(1002);
        orderDetailProduct.setOrderDetailId(orderDetail.getId());
        orderDetailProduct.setProductListId("p1002");
        orderDetailProductRepository.saveAndFlush(orderDetailProduct);


        orderDetailProduct=new OrderDetailProduct();
        orderDetailProduct.setId(1003);
        orderDetailProduct.setOrderDetailId(orderDetail.getId());
        orderDetailProduct.setProductListId("p1003");
        orderDetailProductRepository.saveAndFlush(orderDetailProduct);


    }


    private UserProfile findUserProfile()
    {
        return userProfileRepository.findById(28L).orElse(null);
    }
}
