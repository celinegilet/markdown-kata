package fr.kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarkdownTest {

    private Markdown markdown = new Markdown();

    @Test
    public void normalTextAsAParagraph() {
        // Given
        String input = "This will be a paragraph";

        // When
        String result = markdown.parse(input);

        // Then
        assertThat(result).isEqualTo("<p>This will be a paragraph</p>");
    }

    @Test
    public void italics() {
        // Given
        String input = "_This will be italic_";

        // When
        String result = markdown.parse(input);

        // Then
        assertThat(result).isEqualTo("<p><em>This will be italic</em></p>");
    }

    @Test
    public void boldText() {
        // Given
        String input = "__This will be bold__";

        // When
        String result = markdown.parse(input);

        // Then
        assertThat(result).isEqualTo("<p><strong>This will be bold</strong></p>");
    }

    @Test
    public void normalItalicsAndBoldText() {
        // Given
        String input = "This will _be_ __mixed__";

        // When
        String result = markdown.parse(input);

        // Then
        assertThat(result).isEqualTo("<p>This will <em>be</em> <strong>mixed</strong></p>");
    }

    @Test
    public void withH1HeaderLevel() {
        // Given
        String input = "# This will be an h1";

        // When
        String result = markdown.parse(input);

        // Then
        assertThat(result).isEqualTo("<h1>This will be an h1</h1>");
    }

    @Test
    public void withH2HeaderLevel() {
        // Given
        String input = "## This will be an h2";

        // When
        String result = markdown.parse(input);

        // Then
        assertThat(result).isEqualTo("<h2>This will be an h2</h2>");
    }

    @Test
    public void withH6HeaderLevel() {
        // Given
        String input = "###### This will be an h6";

        // When
        String result = markdown.parse(input);

        // Then
        assertThat(result).isEqualTo("<h6>This will be an h6</h6>");
    }

    @Test
    public void unorderedLists() {
        // Given
        String input = "* Item 1\n* Item 2";

        // When
        String result = markdown.parse(input);

        // Then
        assertThat(result).isEqualTo("<ul><li>Item 1</li><li>Item 2</li></ul>");
    }

    @Test
    public void aLittleBitOfEverything() {
        // Given
        String input = "# Header!\n* __Bold Item__\n* _Italic Item_";

        // When
        String result = markdown.parse(input);

        // Then
        assertThat(result).isEqualTo("<h1>Header!</h1><ul><li><strong>Bold Item</strong></li><li><em>Italic Item</em></li></ul>");
    }

}