package pl.coderslab.crm.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.services.ProjectServiceImpl;

public class ProjectConverter implements Converter<String,Project> {

    @Autowired
    ProjectServiceImpl projectService;
    @Override
    public Project convert(String s) {
        return projectService.findOneById(Long.parseLong(s));
    }
}
