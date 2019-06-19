package com.pss.test;

import com.pss.imagem.processamento.decorator.AzulDecorator;
import com.pss.imagem.processamento.decorator.EspelhadaDecorator;
import com.pss.imagem.processamento.decorator.Imagem;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.PixeladaDecorator;
import com.pss.imagem.processamento.decorator.SalvarImagemDecorator;
import com.pss.imagem.processamento.decorator.TomDeCinzaDecorator;
import java.io.File;
import java.io.IOException;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ProcessamentoImagemTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public ProcessamentoImagemTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void carregaImagem() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        assertTrue(imagem.getImagem() != null);
    }

    @Test
    public void filtro1() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new PixeladaDecorator(imagem, 5);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro2() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new EspelhadaDecorator(imagem);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro3() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new AzulDecorator(imagem);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro4() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new TomDeCinzaDecorator(imagem);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro5() throws IOException, InterruptedException, Exception {

        String caminho = new File("src/main/resources/").getAbsolutePath();
        String nomeArquivo = "pixelada.jpg";
        File arquivo = new File(caminho + "\\" + nomeArquivo);

        
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(CoreMatchers.containsString("A imagem foi salva, nao e possivel reverter"));

        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new PixeladaDecorator(imagem, 5);
        imagem.visualizar();
        
        arquivo.delete();
        imagem = new SalvarImagemDecorator(imagem, nomeArquivo);

        assertTrue(arquivo.exists());
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }
}
