package com.revature.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


@Entity
@SequenceGenerator(name="message_gen", sequenceName="message_seq", allocationSize=1)
public class Message {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="message_gen")
    private int id;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    private User sender;

   @Column
    private int receiver;

    @Column
    private String subject;

    @Column
    private String message;

    @Column
    private Timestamp sentTime;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status; // enum?

    public Message() {
    }

    public Message(User sender, String subject, String message) {
        this.sender = sender;
        this.subject = subject;
        this.message = message;
    }

    public Message(String message, User sender) {
        this.message = message;
        this.sender = sender;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getSentTime() {
        return sentTime;
    }

    public void setSentTime(Timestamp sentTime) {
        this.sentTime = sentTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return id == message1.id &&
                receiver == message1.receiver &&
                Objects.equals(sender, message1.sender) &&
                Objects.equals(subject, message1.subject) &&
                Objects.equals(message, message1.message) &&
                Objects.equals(sentTime, message1.sentTime) &&
                status == message1.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, receiver, subject, message, sentTime, status);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", sentTime=" + sentTime +
                ", status=" + status +
                '}';
    }
}
