package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.GlobalConstants;
import hiberspring.domain.dtos.BranchSeedDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.service.BranchService;
import hiberspring.service.TownService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static hiberspring.common.GlobalConstants.BRANCHES_FILE_PATH;
import static hiberspring.common.GlobalConstants.INCORRECT_DATA_MESSAGE;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public BranchServiceImpl(BranchRepository branchRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, TownService townService) {
        this.branchRepository = branchRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return Files.readString(Path.of(BRANCHES_FILE_PATH));
    }

    @Override
    public String importBranches(String branchesFileContent) throws FileNotFoundException {
        StringBuilder messages = new StringBuilder();
        BranchSeedDto[] branchesDtos = this.gson.fromJson(branchesFileContent, BranchSeedDto[].class);
        Arrays.stream(branchesDtos).forEach(dto -> {
            if (!this.validationUtil.isValid(dto)) {
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }
            if (this.branchRepository.findByName(dto.getName()) != null) {
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }
            Town town = this.townService.findTownByName(dto.getTown());
            if (town == null) {
                messages.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                return;
            }

            Branch branch = this.modelMapper.map(dto, Branch.class);
            branch.setTown(town);
            this.branchRepository.saveAndFlush(branch);
            messages.append(String.format(GlobalConstants.SUCCESSFUL_IMPORT_MESSAGE,Branch.class.getSimpleName(),branch.getName()))
                    .append(System.lineSeparator());
        });
        return messages.toString();
    }

    @Override
    public Branch getBranchByName(String name) {
        return this.branchRepository.findByName(name);
    }
}
