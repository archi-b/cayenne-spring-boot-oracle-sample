package com.archib.cayenne.spring.oracle.example;

import com.archib.cayenne.spring.oracle.example.model.SolicitacaoEmail;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;

import org.apache.cayenne.query.SelectById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {

    private ServerRuntime cayenneRuntime;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }

    @Autowired
    @Qualifier("minhaContaDataSource")
    DataSource minhaContaDataSource;

    @PostConstruct
    public void init(){
        cayenneRuntime = ServerRuntime.builder()
                .addConfig("cayenne-project.xml")
                .dataSource(minhaContaDataSource).build();

        // this.findSolicitacoesEmailById1();
        // this.findSolicitacoesEmailById2();
        // this.findSolicitacoesEmail();
        this.insertSolicitacaoEmail();
        // this.updateSolicitacaoEmail();
        // this.deleteSolicitacaoEmail();
    }

    private SolicitacaoEmail findSolicitacoesEmailById1() {

        ObjectContext context = cayenneRuntime.newContext();
        SolicitacaoEmail solicitacaoEmail = SelectById.query(SolicitacaoEmail.class, 1).selectFirst(context);
        return solicitacaoEmail;
    }

    private SolicitacaoEmail findSolicitacoesEmailById2() {

        ObjectContext context = cayenneRuntime.newContext();
        SolicitacaoEmail solicitacaoEmail = ObjectSelect.query(SolicitacaoEmail.class)
                .where(SolicitacaoEmail.ID_SOLICITACAO.eq(1L)).selectFirst(context);
        return solicitacaoEmail;
    }

    private void findSolicitacoesEmail() {
        ObjectContext context = cayenneRuntime.newContext();

        List<SolicitacaoEmail> result = ObjectSelect.query(SolicitacaoEmail.class)
                .where(SolicitacaoEmail.USERNAME.eq("username"))
                .and(SolicitacaoEmail.SOLICITACAO_CANCELADA.eq(true))
                .and(SolicitacaoEmail.SOLICITACAO_CONFIRMADA.eq(true))
                .select(context);

        result.forEach(System.out::println);
    }

    private void insertSolicitacaoEmail() {
        ObjectContext context = cayenneRuntime.newContext();

        SolicitacaoEmail solicitacaoEmail = context.newObject(SolicitacaoEmail.class);
        solicitacaoEmail.setDataCriacao(Timestamp.valueOf(LocalDateTime.now()));
        solicitacaoEmail.setEmailNew("new@email.com.br");
        solicitacaoEmail.setEmailOld("old@email.com.br");
        solicitacaoEmail.setSolicitacaoCancelada(false);
        solicitacaoEmail.setSolicitacaoConfirmada(false);
        solicitacaoEmail.setSourceUsername("teste");
        solicitacaoEmail.setUsername("me");

        context.commitChanges();
    }

    private void updateSolicitacaoEmail() {
        ObjectContext context = cayenneRuntime.newContext();

        /// Select by Id
        // SolicitacaoEmail solicitacaoEmail1 = SelectById.query(SolicitacaoEmail.class, 1).selectOne(context);
        // solicitacaoEmail1.setUsername("change1");

        /// Select Custom Query
        SolicitacaoEmail solicitacaoEmail2 = ObjectSelect.query(SolicitacaoEmail.class)
                .orderBy(SolicitacaoEmail.DATA_CRIACAO.desc())
                .selectFirst(context);
        solicitacaoEmail2.setUsername("change2");

        context.commitChanges();
    }

    private void deleteSolicitacaoEmail() {
        ObjectContext context = cayenneRuntime.newContext();

        SolicitacaoEmail solicitacaoEmail = ObjectSelect.query(SolicitacaoEmail.class)
                .orderBy(SolicitacaoEmail.DATA_CRIACAO.desc())
                .selectFirst(context);

        context.deleteObject(solicitacaoEmail);
        context.commitChanges();
    }

}
