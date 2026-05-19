---

# # Calculadora de IMC (Índice de Massa Corporal) — Android App

> **Status do Projeto:** Concluído 🚀
> **Contexto:** Projeto acadêmico desenvolvido em Kotlin para dispositivos Android, com foco no estudo de componentes de interface nativos, tratamento de eventos em tempo real (*TextWatcher*) e ciclo de vida de atividades.

---

## ## 🧠 Contextualização Científica e Prática

O **Índice de Massa Corporal (IMC)** é uma ferramenta internacional reconhecida pela Organização Mundial da Saúde (OMS) utilizada no rastreio preliminar do estado nutricional de indivíduos adultos.

Do ponto de vista técnico e de Engenharia de Software, o desenvolvimento desta aplicação envolveu a superação de desafios práticos do ecossistema mobile, como:

* **Design Responsivo com ConstraintLayout:** Organização de elementos visuais de forma proporcional, garantindo adaptabilidade a diferentes resoluções de ecrã.
* **Design System com Material Components:** Utilização de `TextInputLayout` e `TextInputEditText` para entregar uma experiência de utilizador (UX) moderna, fluida e integrada às diretrizes do Material Design.
* **Robustez e Tratamento de Exceções:** Implementação de regras de validação lógica para entradas de dados, mitigando comportamentos inesperados causados por valores nulos, vazios ou biologicamente implausíveis.

---

## ## 📐 Lógica de Negócio e Engenharia do Software

A aplicação foi estruturada sobre a fórmula matemática padrão da OMS para o cálculo de massa corporal:

$$IMC = \frac{\text{peso}}{\text{altura}^2}$$

### ### Diferenciais Técnicos Implementados

1. **Máscaras Dinâmicas em Tempo Real (*TextWatcher*):**
A aplicação processa o texto inserido pelo utilizador em tempo real, aplicando máscaras decimais para facilitar a digitação no teclado numérico:
* **Peso:** Adiciona automaticamente o ponto decimal dinâmico (ex: o utilizador digita `605` e o sistema converte para `60.5`).
* **Altura:** Formata estritamente a entrada métrica (ex: `170` é transformado automaticamente em `1.70`).


2. **Validação Estrita de Dados (*Data Validation*):**
Antes de processar o cálculo, o sistema valida se as entradas estão contidas dentro de limites biológicos realistas através de condicionais bem delimitadas:
* **Peso permitido:** $10.0\text{ kg} \le \text{peso} \le 500.0\text{ kg}$
* **Altura permitida:** $0.5\text{ m} \le \text{altura} \le 2.6\text{ m}$
* Caso o dado seja inválido, um alerta de erro nativo (`.error`) é exibido diretamente no campo de texto correspondente.


3. **Arquitetura de Telas e Comunicação Inter-Activity:**
Em vez de processar e exibir os dados na mesma tela, o app utiliza o mecanismo de **`Intent`** combinado a um **`Bundle`** para serializar os dados validados de peso e altura, transferindo o fluxo de execução de `MainActivity` para `resultado_act`, garantindo uma arquitetura limpa e de fácil manutenção.

---

## ## 🗺️ Arquitetura de Telas (User Flow)

### ### 1. Tela Principal (`MainActivity`)

* **Identidade Visual:** Fundo customizado (`#341539`) com a inclusão de logótipo da aplicação via `ImageView`.
* **Entradas:** Campos formatados para inserção de peso e altura.
* **Ação:** Botão "Calcular" estilizado que valida as informações antes de enviar o utilizador para a próxima fase.

### ### 2. Tela de Diagnóstico (`resultado_act`)

* **Identidade Visual:** Variação tonal do fundo (`#441C4D`) para quebrar a monotonia visual e indicar mudança de contexto.
* **Saída de Dados:** Exibição clara do peso e altura recebidos da tela anterior.
* **Diagnóstico Gerado:** Classificação baseada no resultado do IMC calculado em tempo de execução:
* **IMC < 10.5:** Baixo
* **10.5 a 24.9:** Normal
* **25.0 a 29.9:** Sobrepeso
* **Maior que 29.9:** Obeso



---

## ## 🛠️ Stack Tecnológica

* **Linguagem:** Kotlin
* **Plataforma de Desenvolvimento:** Android (Mínimo recomendado: SDK com suporte a *Edge-to-Edge* layouts)
* **IDE:** Android Studio
* **Layout Engine:** `ConstraintLayout` & `Material Components`

---

## ## ⚙️ Como Clonar e Executar o Projeto

1. Execute o clone do repositório no seu terminal local:
```bash
git clone https://github.com/verstl0l/APP_Calcular_IMC.git

```


2. Abra o **Android Studio**.
3. Vá em **File > Open** e selecione o diretório do projeto clonado.
4. Aguarde a sincronização e indexação do **Gradle**.
5. Conecte um dispositivo físico ou inicie um emulador (AVD).
6. Clique no botão **Run** (`Shift + F10`) para compilar e instalar o ficheiro `.apk`.

---

## ## ⚠️ Isenção de Responsabilidade (Disclaimer)

Este projeto possui propósitos puramente didáticos, construído para demonstrar proficiência técnica em desenvolvimento Android nativo com Kotlin. As classificações de IMC exibidas seguem balizadores genéricos de algoritmos de teste e **não** devem ser utilizadas como diagnóstico clínico ou substituto para consultas com profissionais de saúde (médicos ou nutricionistas).

---

A lógica de formatação de string que você fez no `TextWatcher` e o tratamento com o `.error` são ótimos exemplos de boas práticas de programação mobile. Esse README valoriza exatamente isso! Deseja ajustar mais algum detalhe do texto?
