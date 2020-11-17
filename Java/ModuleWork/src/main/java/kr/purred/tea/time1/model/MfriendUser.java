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
public class MfriendUser implements UserModel
{
	private Long idx;

	private String name;

	private String password;

	private String email;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdDate;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime updatedDate;

	@Override
	public Long getPk ()
	{
		return idx;
	}

	@Override
	public String getMyName ()
	{
		return name;
	}

	@Override
	public String getMyEmail ()
	{
		return email;
	}
}
