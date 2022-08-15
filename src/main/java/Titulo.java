import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.Month;

import static java.time.Month.*;
import static org.springframework.http.HttpStatus.CREATED;

//public class Titulo {
//    @PostMapping
//    @ResponseStatus(CREATED)
//    @Deprecated
//    public BankSlipRegisterOutDTO registerBankSlipDeprecated(@RequestHeader(CLIENT_ID) Long clientId,
//                                                             @RequestHeader(IDENTITY_ID) Long identityId,
//                                                             @RequestHeader(value = AUTHORIZER_IDENTITY_ID, required = false) Long sbAuthorizerIdentityId,
//                                                             @Valid @RequestBody BankSlipRegisterInDTODeprecated bankSlipRegisterInDTODeprecated,
//                                                             HttpServletResponse httpServletResponse) {
//        final LocalDateTime localDateTime = LocalDateTime.of(2022, MAY, 1, 23, 59, 59);
//        httpServletResponse.addHeader(SUNSET, DateUtils.toRFC5322Format(localDateTime));
//        return bankSlipServiceImpl.registerDeprecated(clientId, identityId, sbAuthorizerIdentityId, bankSlipRegisterInDTODeprecated);
//    }
//
//    @PostMapping("/v1")
//    @ResponseStatus(CREATED)
//    public ResponseDataDTO<BankSlipRegisterOutDTO> registerBankSlip(@RequestHeader(CLIENT_ID) Long clientId,
//                                                                    @RequestHeader(IDENTITY_ID) Long identityId,
//                                                                    @RequestHeader(value = AUTHORIZER_IDENTITY_ID, required = false) Long sbAuthorizerIdentityId,
//                                                                    @Valid @RequestBody BankSlipRegisterInDTO billet) {
//        return bankSlipServiceImpl.register(clientId, identityId, sbAuthorizerIdentityId, billet);
//    }
//
//    @PatchMapping
//    @ResponseStatus(ACCEPTED)
//    public ResponseDataDTO<String> updateBankSlip(@RequestHeader(CLIENT_ID) Long clientId,
//                                                  @Valid @RequestBody BankSlipUpdateInDTO billet) {
//        return bankSlipServiceImpl.update(clientId, billet);
//    }
//
//    @PostMapping("deposit")
//    @ResponseStatus(CREATED)
//    public BankSlipRegisterOutDTO registerBankSlipDeposit(@RequestHeader(CLIENT_ID) Long clientId,
//                                                          @RequestHeader(IDENTITY_ID) Long identityId,
//                                                          @RequestHeader(value = AUTHORIZER_IDENTITY_ID, required = false) Long sbAuthorizerIdentityId,
//                                                          @Valid @RequestBody BankSlipDepositInDTO depositModel) {
//        return bankSlipServiceImpl.registerDeposit(clientId, identityId, sbAuthorizerIdentityId, depositModel);
//    }
//
//    @GetMapping("/deposit/limit")
//    public BankSlipDepositInfoOperationOutDTO getBankSlipDepositLimits(@RequestHeader(CLIENT_ID) Long clientId,
//                                                                       @RequestHeader(IDENTITY_ID) Long identityId) {
//        return bankSlipServiceImpl.getBankSlipDepositInfoOperation(clientId); // not use identityId
//    }
//
//    @GetMapping("hash/{hash}")
//    public BankSlipGetOutDTO getBankSlip(@RequestHeader(CLIENT_ID) Long clientId,
//                                         @RequestHeader(IDENTITY_ID) Long identityId,
//                                         @PathVariable(value = "hash", required = true) String hash) {
//        return bankSlipServiceImpl.findOneByHash(clientId, identityId, hash); // not send webhook with identityId
//    }
//
//    @PutMapping("/hash/{hash}/cancel")
//    @Deprecated
//    public void cancelBankSliDeprecated(@RequestHeader(CLIENT_ID) Long clientId,
//                                        @RequestHeader(IDENTITY_ID) Long identityId,
//                                        @PathVariable String hash) {
//        bankSlipServiceImpl.effectiveLowDeprecated(clientId, identityId, hash);
//    }
//
//    @DeleteMapping("/v1/{hash}")
//    @ResponseStatus(code = ACCEPTED)
//    public ResponseDataDTO<String> cancelBankSlip(@RequestHeader(CLIENT_ID) Long clientId,
//                                                  @RequestHeader(IDENTITY_ID) Long identityId,
//                                                  @PathVariable String hash) {
//
//
//        bankSlipServiceImpl.checkout(clientId, identityId, hash);
//        return new ResponseDataDTOMapper<String>().toResponseData(null);
//    }
//
//    @GetMapping("/v0/{conciliationId}/{receiverDocumentNumber}")
//    public ResponseDataDTO<BankSlipByPixIdGetOutDTO> findBolepixData(@PathVariable(value = "conciliationId") String conciliationId,
//                                                                     @PathVariable(value = "receiverDocumentNumber") String receiverDocumentNumber) {
//        final BankSlipByPixIdGetOutDTO response = bankSlipServiceImpl.findBolepixData(conciliationId, receiverDocumentNumber);
//        return new ResponseDataDTOMapper<BankSlipByPixIdGetOutDTO>().toResponseData(response);
//    }
//
//    @GetMapping("hash/{hash}/pdfDownload")
//    public Resource pdfDownload(@RequestHeader(CLIENT_ID) Long clientId,
//                                @RequestHeader(IDENTITY_ID) Long identityId,
//                                @PathVariable(value = "hash") String hash, HttpServletResponse response) {
//        byte[] file = bankSlipServiceImpl.pdfDownload(clientId, identityId, hash); // not use identityId
//        ByteArrayResource resource = new ByteArrayResource(file);
//        response.setHeader("content-disposition", "attachment; filename = doc.pdf");
//        response.setHeader("Content-Length", String.valueOf(resource.contentLength()));
//        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
//        return resource;
//    }
//
//    @PutMapping("/agreementId/{agreementId}/cancel/backoffice")
//    public void cancelBankSlipBatch(@PathVariable String agreementId,
//                                    @RequestHeader(CLIENT_ID) Long backofficeClientId,
//                                    @RequestHeader(IDENTITY_ID) Long backofficeIdentityId) {
//        bankSlipServiceImpl.cancelBankSlipBatchByAgreementId(agreementId);
//    }
//
//    @PutMapping("/cpfcnpj/{cpfcnpj}/cancel/backoffice")
//    public void cancelBankSlipBatchByBeneficiary(@PathVariable String cpfcnpj,
//                                                 @RequestHeader(CLIENT_ID) Long backofficeClientId,
//                                                 @RequestHeader(IDENTITY_ID) Long backofficeIdentityId) {
//        bankSlipServiceImpl.cancelBankSlipBatchByCpfCnpjBeneficiary(cpfcnpj);
//    }
//
//    @PutMapping("/hash/{hash}/reprocess")
//    public BankSlipRegisterOutDTO reprocess(@PathVariable String hash) {
//        return this.bankSlipServiceImpl.reprocess(hash);
//    }
//
//
//
//
//