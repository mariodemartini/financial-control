package com.financial_control.services;

import com.financial_control.dtos.responses.InvoiceResponseDTO;
import com.financial_control.entities.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface InvoiceService {

    InvoiceResponseDTO createInvoice(BigDecimal amount, LocalDate date, Long card);
    InvoiceResponseDTO findInvoiceByStatus(StatusEnum status);
    InvoiceResponseDTO findInvoiceByMonth(LocalDate month, Long cardId);
    //InvoiceResponseDTO updateInvoice(Long id, InvoiceRequestDTO invoiceRequestDTO);

}
