package ahpu.libra.service;

import ahpu.libra.entity.NoteResult;

public interface AdminService {
	public NoteResult checkLogin(String name,String password);
	
	public NoteResult checkLogin(String admin);
}
