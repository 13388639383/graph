package com.graph.Service;

import com.graph.Domain.Result;

import java.io.IOException;

public interface InputService {

    boolean inputText(String inputtext) throws IOException;

    Result showMessage(String artname, String artinfo, String artclass);
}
