package kr.purred.tea.time1.model;

import java.time.LocalDateTime;

import kr.purred.tea.time1.inter.UserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MyUser implements UserModel
{
	private Long no;

	private String userName;

	private String password;

	private String userEmail;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdDate;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime updatedDate;

	@Override
	public Long getPk ()
	{
		return no;
	}

	@Override
	public String getMyName ()
	{
		return userName;
	}

	@Override
	public String getMyEmail ()
	{
		return userEmail;
	}
}
