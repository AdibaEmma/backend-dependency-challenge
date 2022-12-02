package com.mhp.coding.challenges.dependency.notifications

import com.mhp.coding.challenges.dependency.inquiry.Inquiry
import com.mhp.coding.challenges.dependency.inquiry.InquiryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
class InquiryHandler (
    @Autowired private val inquiryService: InquiryService,
    @Autowired private val emailHandler: EmailHandler,
    @Autowired private val pushNotificationHandler: PushNotificationHandler
){

    fun handleInquiry(inquiry: Inquiry) {

        inquiryService.create(inquiry).also {
            emailHandler.sendEmail(inquiry)
            pushNotificationHandler.sendNotification(inquiry)
        }
    }
}