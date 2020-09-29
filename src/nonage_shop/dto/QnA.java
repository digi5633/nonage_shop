package nonage_shop.dto;

import java.sql.Timestamp;

public class QnA {
	private int qseq;
	private String subject;
	private String content;
	private String reply;
	private String id;
	private String rep;
	private Timestamp indate;

	public QnA() {
		super();
	}

	public QnA(int qseq, String subject, String content, String reply, String id, String rep, Timestamp indate) {
		this.qseq = qseq;
		this.subject = subject;
		this.content = content;
		this.reply = reply;
		this.id = id;
		this.rep = rep;
		this.indate = indate;
	}

	public QnA(int qseq) {
		this.qseq = qseq;
	}

	public int getQseq() {
		return qseq;
	}

	public void setQseq(int qseq) {
		this.qseq = qseq;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRep() {
		return rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

	public Timestamp getIndate() {
		return indate;
	}

	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "Qna [qseq=" + qseq + ", subject=" + subject + ", content=" + content + ", reply=" + reply + ", id=" + id
				+ ", rep=" + rep + ", indate=" + indate + "]";
	}

}