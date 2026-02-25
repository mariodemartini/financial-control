package com.financial_control.services.impl;

import com.financial_control.dtos.responses.InvoiceResponseDTO;
import com.financial_control.entities.enums.StatusEnum;
import com.financial_control.mappers.InvoiceMapper;
import com.financial_control.repositories.CardsRepository;
import com.financial_control.repositories.InvoiceRepository;
import com.financial_control.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private CardsRepository cardsRepository;


    @Override
    public InvoiceResponseDTO createInvoice(BigDecimal amount, LocalDate date, Long card) {
        return null;
    }

    @Override
    public InvoiceResponseDTO findInvoiceByStatus(StatusEnum status) {
        return null;
    }

    @Override
    public InvoiceResponseDTO findInvoiceByMonth(LocalDate month, Long cardId) {
        return null;
    }

//    @Override
//    public InvoiceResponseDTO updateInvoice(Long id, InvoiceRequestDTO invoiceRequestDTO) {
//        return null;
//    }

}
