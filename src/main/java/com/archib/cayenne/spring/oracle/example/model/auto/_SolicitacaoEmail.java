package com.archib.cayenne.spring.oracle.example.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _SolicitacaoEmail was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _SolicitacaoEmail extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_SOLICITACAO_PK_COLUMN = "ID_SOLICITACAO";

    public static final Property<Timestamp> DATA_CRIACAO = Property.create("dataCriacao", Timestamp.class);
    public static final Property<Timestamp> DATA_EXPIRACAO = Property.create("dataExpiracao", Timestamp.class);
    public static final Property<String> EMAIL_NEW = Property.create("emailNew", String.class);
    public static final Property<String> EMAIL_OLD = Property.create("emailOld", String.class);
    public static final Property<Boolean> SOLICITACAO_CONFIRMADA = Property.create("solicitacaoConfirmada", Boolean.class);
    public static final Property<String> SOURCE_USERNAME = Property.create("sourceUsername", String.class);
    public static final Property<String> USERNAME = Property.create("username", String.class);
    public static final Property<Boolean> SOLICITACAO_CANCELADA = Property.create("solicitacaoCancelada", Boolean.class);
    public static final Property<Long> ID_SOLICITACAO = Property.create("idSolicitacao", Long.class);

    protected Timestamp dataCriacao;
    protected Timestamp dataExpiracao;
    protected String emailNew;
    protected String emailOld;
    protected boolean solicitacaoConfirmada;
    protected String sourceUsername;
    protected String username;
    protected boolean solicitacaoCancelada;
    protected Long idSolicitacao;


    public void setDataCriacao(Timestamp dataCriacao) {
        beforePropertyWrite("dataCriacao", this.dataCriacao, dataCriacao);
        this.dataCriacao = dataCriacao;
    }

    public Timestamp getDataCriacao() {
        beforePropertyRead("dataCriacao");
        return this.dataCriacao;
    }

    public void setDataExpiracao(Timestamp dataExpiracao) {
        beforePropertyWrite("dataExpiracao", this.dataExpiracao, dataExpiracao);
        this.dataExpiracao = dataExpiracao;
    }

    public Timestamp getDataExpiracao() {
        beforePropertyRead("dataExpiracao");
        return this.dataExpiracao;
    }

    public void setEmailNew(String emailNew) {
        beforePropertyWrite("emailNew", this.emailNew, emailNew);
        this.emailNew = emailNew;
    }

    public String getEmailNew() {
        beforePropertyRead("emailNew");
        return this.emailNew;
    }

    public void setEmailOld(String emailOld) {
        beforePropertyWrite("emailOld", this.emailOld, emailOld);
        this.emailOld = emailOld;
    }

    public String getEmailOld() {
        beforePropertyRead("emailOld");
        return this.emailOld;
    }

    public void setSolicitacaoConfirmada(boolean solicitacaoConfirmada) {
        beforePropertyWrite("solicitacaoConfirmada", this.solicitacaoConfirmada, solicitacaoConfirmada);
        this.solicitacaoConfirmada = solicitacaoConfirmada;
    }

	public boolean isSolicitacaoConfirmada() {
        beforePropertyRead("solicitacaoConfirmada");
        return this.solicitacaoConfirmada;
    }

    public void setSourceUsername(String sourceUsername) {
        beforePropertyWrite("sourceUsername", this.sourceUsername, sourceUsername);
        this.sourceUsername = sourceUsername;
    }

    public String getSourceUsername() {
        beforePropertyRead("sourceUsername");
        return this.sourceUsername;
    }

    public void setUsername(String username) {
        beforePropertyWrite("username", this.username, username);
        this.username = username;
    }

    public String getUsername() {
        beforePropertyRead("username");
        return this.username;
    }

    public void setSolicitacaoCancelada(boolean solicitacaoCancelada) {
        beforePropertyWrite("solicitacaoCancelada", this.solicitacaoCancelada, solicitacaoCancelada);
        this.solicitacaoCancelada = solicitacaoCancelada;
    }

	public boolean isSolicitacaoCancelada() {
        beforePropertyRead("solicitacaoCancelada");
        return this.solicitacaoCancelada;
    }

    public void setIdSolicitacao(Long idSolicitacao) {
        beforePropertyWrite("idSolicitacao", this.idSolicitacao, idSolicitacao);
        this.idSolicitacao = idSolicitacao;
    }

    public Long getIdSolicitacao() {
        beforePropertyRead("idSolicitacao");
        return this.idSolicitacao;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "dataCriacao":
                return this.dataCriacao;
            case "dataExpiracao":
                return this.dataExpiracao;
            case "emailNew":
                return this.emailNew;
            case "emailOld":
                return this.emailOld;
            case "solicitacaoConfirmada":
                return this.solicitacaoConfirmada;
            case "sourceUsername":
                return this.sourceUsername;
            case "username":
                return this.username;
            case "solicitacaoCancelada":
                return this.solicitacaoCancelada;
            case "idSolicitacao":
                return this.idSolicitacao;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "dataCriacao":
                this.dataCriacao = (Timestamp)val;
                break;
            case "dataExpiracao":
                this.dataExpiracao = (Timestamp)val;
                break;
            case "emailNew":
                this.emailNew = (String)val;
                break;
            case "emailOld":
                this.emailOld = (String)val;
                break;
            case "solicitacaoConfirmada":
                this.solicitacaoConfirmada = val == null ? false : (boolean)val;
                break;
            case "sourceUsername":
                this.sourceUsername = (String)val;
                break;
            case "username":
                this.username = (String)val;
                break;
            case "solicitacaoCancelada":
                this.solicitacaoCancelada = val == null ? false : (boolean)val;
                break;
            case "idSolicitacao":
                this.idSolicitacao = (Long)val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.dataCriacao);
        out.writeObject(this.dataExpiracao);
        out.writeObject(this.emailNew);
        out.writeObject(this.emailOld);
        out.writeBoolean(this.solicitacaoConfirmada);
        out.writeObject(this.sourceUsername);
        out.writeObject(this.username);
        out.writeBoolean(this.solicitacaoCancelada);
        out.writeObject(this.idSolicitacao);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.dataCriacao = (Timestamp)in.readObject();
        this.dataExpiracao = (Timestamp)in.readObject();
        this.emailNew = (String)in.readObject();
        this.emailOld = (String)in.readObject();
        this.solicitacaoConfirmada = in.readBoolean();
        this.sourceUsername = (String)in.readObject();
        this.username = (String)in.readObject();
        this.solicitacaoCancelada = in.readBoolean();
        this.idSolicitacao = (Long)in.readObject();
    }

}