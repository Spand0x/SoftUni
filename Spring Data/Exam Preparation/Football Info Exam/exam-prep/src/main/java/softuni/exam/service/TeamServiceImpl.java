package softuni.exam.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.TeamSeedRootDto;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;


import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.GlobalConstants.TEAM_PATH;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;
    private final PictureService pictureService;

    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser, PictureService pictureService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
        this.pictureService = pictureService;
    }


    @Override
    
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder messages = new StringBuilder();
        TeamSeedRootDto teamRootDto = this.xmlParser.importFromXml(TeamSeedRootDto.class, TEAM_PATH);
        teamRootDto.getTeams().forEach(t->{
            if(this.validatorUtil.isValid(t)){
                if(this.teamRepository.findByName(t.getName()) == null){
                    if(this.pictureService.getPictureByUrl(t.getPicture().getUrl()) != null){
                        Team team = this.modelMapper.map(t, Team.class);
                        team.setPicture(this.pictureService.getPictureByUrl(t.getPicture().getUrl()));
                        this.teamRepository.saveAndFlush(team);
                        messages.append("Successfully imported team - ").append(t.getName());
                    }else {
                        messages.append("Invalid team");
                    }
                }else {
                    messages.append("Team already in DB");
                }
            }else {
                messages.append("Invalid team");
            }
            messages.append(System.lineSeparator());
        });
        return messages.toString();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count()>0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(Path.of(TEAM_PATH));
    }

    @Override
    public Team getTeamByName(String name) {
        return this.teamRepository.findByName(name);
    }

}
