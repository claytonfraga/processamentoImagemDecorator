package com.pss.test;

import com.pss.imagem.processamento.decorator.AzulDecorator;
import com.pss.imagem.processamento.decorator.BrilhoDecorator;
import com.pss.imagem.processamento.decorator.EspelhadaDecorator;
import com.pss.imagem.processamento.decorator.Imagem;
import com.pss.imagem.processamento.decorator.ImagemComponente;
import com.pss.imagem.processamento.decorator.NegativaDecorator;
import com.pss.imagem.processamento.decorator.PixeladaDecorator;
import com.pss.imagem.processamento.decorator.RotacionaDecorator;
import com.pss.imagem.processamento.decorator.SalvarImagemDecorator;
import com.pss.imagem.processamento.decorator.SepiaDecorator;
import com.pss.imagem.processamento.decorator.TomDeCinzaDecorator;
import com.pss.imagem.processamento.decorator.VerdeDecorator;
import com.pss.imagem.processamento.decorator.VermelhoDecorator;
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

    @Test
    public void filtro6() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new NegativaDecorator(imagem);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro7() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new RotacionaDecorator(imagem, 90);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro8() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new SepiaDecorator(imagem);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro9() throws IOException, InterruptedException, Exception {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(CoreMatchers.containsString("Informe um arquivo JPG"));

        ImagemComponente imagem = new Imagem("lenna");
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro10() throws IOException, InterruptedException, Exception {

        thrown.expect(IOException.class);
        thrown.expectMessage(CoreMatchers.containsString("Falha: Não foi possivel abrir a imagem \n"));

        ImagemComponente imagem = new Imagem("lennaxxx.jpg");
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro11() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new BrilhoDecorator(imagem, 20);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro12() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new VerdeDecorator(imagem);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro13() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new VermelhoDecorator(imagem);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro14() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new RotacionaDecorator(imagem, 0);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro15() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new RotacionaDecorator(imagem, 40);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro16() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new RotacionaDecorator(imagem, 179);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro17() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new RotacionaDecorator(imagem, 269);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro18() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem = new RotacionaDecorator(imagem, 271);
        assertTrue(imagem.getImagem() != imagem.reverter().getImagem());
    }

    @Test
    public void filtro19() throws IOException, InterruptedException, Exception {
        ImagemComponente imagem = new Imagem("lenna.jpg");
        imagem.reverter();

        assertTrue(imagem.getImagem() != null);
    }

}
