package com.verhext.sharkmeapi.models;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("card")
public class CardModel {
    @PrimaryKey
    private UUID id;
    private String question;
    private String answer;
    @Column(forceQuote = true)
    private String questionNote;
    @Column(forceQuote = true)
    private String answerNote;
    private String grammar;
    @Column(forceQuote = true)
    private String dictionaryUrl;
    private UUID box;

    public CardModel() {
    }

    public CardModel(UUID id, String question, String answer, String questionNote, String answerNote, String grammar,
            String dictionaryUrl, UUID box) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.questionNote = questionNote;
        this.answerNote = answerNote;
        this.grammar = grammar;
        this.dictionaryUrl = dictionaryUrl;
        this.box = box;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionNote() {
        return this.questionNote;
    }

    public void setQuestionNote(String questionNote) {
        this.questionNote = questionNote;
    }

    public String getAnswerNote() {
        return this.answerNote;
    }

    public void setAnswerNote(String answerNote) {
        this.answerNote = answerNote;
    }

    public String getGrammar() {
        return this.grammar;
    }

    public void setGrammar(String grammar) {
        this.grammar = grammar;
    }

    public String getDictionaryUrl() {
        return this.dictionaryUrl;
    }

    public void setDictionaryUrl(String dictionaryUrl) {
        this.dictionaryUrl = dictionaryUrl;
    }

    public UUID getBox() {
        return this.box;
    }

    public void setBox(UUID box) {
        this.box = box;
    }

    public CardModel id(UUID id) {
        this.id = id;
        return this;
    }

    public CardModel question(String question) {
        this.question = question;
        return this;
    }

    public CardModel answer(String answer) {
        this.answer = answer;
        return this;
    }

    public CardModel questionNote(String questionNote) {
        this.questionNote = questionNote;
        return this;
    }

    public CardModel answerNote(String answerNote) {
        this.answerNote = answerNote;
        return this;
    }

    public CardModel grammar(String grammar) {
        this.grammar = grammar;
        return this;
    }

    public CardModel dictionaryUrl(String dictionaryUrl) {
        this.dictionaryUrl = dictionaryUrl;
        return this;
    }

    public CardModel box(UUID box) {
        this.box = box;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CardModel)) {
            return false;
        }
        CardModel cardModel = (CardModel) o;
        return Objects.equals(id, cardModel.id) && Objects.equals(question, cardModel.question)
                && Objects.equals(answer, cardModel.answer) && Objects.equals(questionNote, cardModel.questionNote)
                && Objects.equals(answerNote, cardModel.answerNote) && Objects.equals(grammar, cardModel.grammar)
                && Objects.equals(dictionaryUrl, cardModel.dictionaryUrl) && Objects.equals(box, cardModel.box);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, questionNote, answerNote, grammar, dictionaryUrl, box);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", question='" + getQuestion() + "'" + ", answer='" + getAnswer() + "'"
                + ", questionNote='" + getQuestionNote() + "'" + ", answerNote='" + getAnswerNote() + "'"
                + ", grammar='" + getGrammar() + "'" + ", dictionaryUrl='" + getDictionaryUrl() + "'" + ", box='"
                + getBox() + "'" + "}";
    }

}