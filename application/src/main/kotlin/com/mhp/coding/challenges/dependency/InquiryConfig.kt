package com.mhp.coding.challenges.dependency

import com.mhp.coding.challenges.dependency.inquiry.Inquiry
import com.mhp.coding.challenges.dependency.notifications.InquiryHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class InquiryConfig(@Autowired private  val inquiryHandler: InquiryHandler,
    ) {

    @Autowired
    fun manageInquiry() {
        val inquiry = Inquiry(
            username = "TestUser",
            recipient = "service@example.com",
            text = "Can I haz cheezburger?",
        )
        inquiryHandler.handleInquiry(inquiry)
    }
}