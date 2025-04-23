package de.bmarwell.snailspace.demo4.app.services.api;

import de.bmarwell.snailspace.demo4.app.common.value.MailId;

public record MailSendStatus(MailId mailId, String status) { }
