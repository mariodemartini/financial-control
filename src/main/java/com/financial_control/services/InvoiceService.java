package com.financial_control.services;

import com.financial_control.dtos.requests.InvoiceRequestDTO;
import com.financial_control.dtos.responses.InvoiceResponseDTO;
import com.financial_control.entities.enums.StatusEnum;

import java.time.LocalDate;

public interface InvoiceService {

    InvoiceResponseDTO createInvoice(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO findInvoiceByStatus(StatusEnum status);
    InvoiceResponseDTO findInvoiceByMonth(LocalDate month, Long cardId);
    InvoiceResponseDTO updateInvoice(Long id, InvoiceRequestDTO invoiceRequestDTO);

}
