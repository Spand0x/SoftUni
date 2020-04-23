package softuni.exam.service;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.PlayerSeedRootDto;
import softuni.exam.domain.entities.Player;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidatorUtil;


import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static softuni.exam.constants.GlobalConstants.PLAYER_PATH;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamService teamService;
    private final PictureService pictureService;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    public PlayerServiceImpl(PlayerRepository playerRepository, TeamService teamService, PictureService pictureService, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.playerRepository = playerRepository;
        this.teamService = teamService;
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }


    @Override
    public String importPlayers() throws FileNotFoundException {
        StringBuilder messages = new StringBuilder();
        PlayerSeedRootDto[] playersRootDto = this.gson.fromJson(new FileReader(PLAYER_PATH), PlayerSeedRootDto[].class);
        Arrays.stream(playersRootDto).forEach(dto -> {
            if (!this.validatorUtil.isValid(dto)) {
                messages.append("Invalid player").append(System.lineSeparator());
                return;
            }
            if (this.playerRepository.getByFirstNameAndLastName(dto.getFirstName(), dto.getLastName()) != null) {
                messages.append("Invalid player").append(System.lineSeparator());
                return;
            }
            if (this.pictureService.getPictureByUrl(dto.getPicture().getUrl()) == null) {
                messages.append("Invalid player").append(System.lineSeparator());
                return;
            }
            if (this.teamService.getTeamByName(dto.getTeam().getName()) == null) {
                messages.append("Invalid player").append(System.lineSeparator());
                return;
            }
            Player player = this.modelMapper.map(dto, Player.class);
            player.setPicture(this.pictureService.getPictureByUrl(dto.getPicture().getUrl()));
            player.setTeam(this.teamService.getTeamByName(dto.getTeam().getName()));
            this.playerRepository.saveAndFlush(player);
            messages.append("Successfully imported player - ").append(dto.getFirstName())
                    .append(" ").append(dto.getLastName()).append(System.lineSeparator());

        });
        return messages.toString();
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(PLAYER_PATH));
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder playersString = new StringBuilder();
        BigDecimal salary = new BigDecimal(100000);
        List<Player> players = this.playerRepository.getAllBySalaryGreaterThanOrderBySalaryDesc(salary);
        players.forEach(p->{
            playersString.append(String.format("Player name: %s %s \n" +
                    "\tNumber: %d\n" +
                    "\tSalary: %s\n" +
                    "\tTeam: %s",
                    p.getFirstName(),
                    p.getLastName(),
                    p.getNumber(),
                    p.getSalary().toString(),
                    p.getTeam().getName())).append(System.lineSeparator());
        });

        return playersString.toString();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder teamAndPlayers = new StringBuilder();
        String teamName = "North Hub";
        List<Player> playersInTeam = this.playerRepository.getAllByTeamNameEquals(teamName);
        teamAndPlayers.append("Team: ").append(teamName).append(System.lineSeparator());
        playersInTeam.forEach(p -> {
            teamAndPlayers.append(String.format(
                    "\tPlayer name: %s %s - %s\n" +
                    "\tNumber: %d",
                    p.getFirstName(),
                    p.getLastName(),
                    p.getPosition().name(),
                    p.getNumber())).append(System.lineSeparator());
        });

        return teamAndPlayers.toString();
    }


}
