package com.archib.cayenne.spring.oracle.example.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _SolicitacaoVinculo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _SolicitacaoVinculo extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_SOLICITACAO_PK_COLUMN = "ID_SOLICITACAO";

    public static final Property<BigDecimal> COD_EC = Property.create("codEc", BigDecimal.class);
    public static final Property<Timestamp> DATA_CRIACAO = Property.create("dataCriacao", Timestamp.class);
    public static final Property<Timestamp> DATA_EXPIRACAO = Property.create("dataExpiracao", Timestamp.class);
    public static final Property<String> USERNAME = Property.create("username", String.class);

    protected BigDecimal codEc;
    protected Timestamp dataCriacao;
    protected Timestamp dataExpiracao;
    protected String username;


    public void setCodEc(BigDecimal codEc) {
        beforePropertyWrite("codEc", this.codEc, codEc);
        this.codEc = codEc;
    }

    public BigDecimal getCodEc() {
        beforePropertyRead("codEc");
        return this.codEc;
    }

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

    public void setUsername(String username) {
        beforePropertyWrite("username", this.username, username);
        this.username = username;
    }

    public String getUsername() {
        beforePropertyRead("username");
        return this.username;
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "codEc":
                return this.codEc;
            case "dataCriacao":
                return this.dataCriacao;
            case "dataExpiracao":
                return this.dataExpiracao;
            case "username":
                return this.username;
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
            case "codEc":
                this.codEc = (BigDecimal)val;
                break;
            case "dataCriacao":
                this.dataCriacao = (Timestamp)val;
                break;
            case "dataExpiracao":
                this.dataExpiracao = (Timestamp)val;
                break;
            case "username":
                this.username = (String)val;
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
        out.writeObject(this.codEc);
        out.writeObject(this.dataCriacao);
        out.writeObject(this.dataExpiracao);
        out.writeObject(this.username);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.codEc = (BigDecimal)in.readObject();
        this.dataCriacao = (Timestamp)in.readObject();
        this.dataExpiracao = (Timestamp)in.readObject();
        this.username = (String)in.readObject();
    }

}