package com.handex.persistence;

import com.handex.representations.Export;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExportDao extends JpaRepository<Export, Long> {
}
