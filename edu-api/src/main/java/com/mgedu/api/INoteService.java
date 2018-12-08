package com.mgedu.api;

import com.mgedu.dto.NoteBean;
import org.springframework.stereotype.Component;

/**
 * @author heyanjing
 * date:2018-12-07 2018/12/7:15:21
 */
public interface INoteService {
     NoteBean createNote(NoteBean note);
     NoteBean getNoteById(String noteId);
}
